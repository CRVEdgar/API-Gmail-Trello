package com.example.trelloservice.controller;

import com.example.trelloservice.controller.assemblerConvert.CardConvertAssembler;
import com.example.trelloservice.controller.assemblerConvert.CardConvertDISAssembler;
import com.example.trelloservice.controller.dto.DtoCard;
import com.example.trelloservice.controller.input.CardInput;
import com.example.trelloservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trello-service")
public class CardController {

    //TODO - handler

    @Autowired
    private CardService service;

    @Autowired
    private CardConvertAssembler cardConvertAssembler;

    @Autowired
    private CardConvertDISAssembler cardConvertDISAssembler;

    @GetMapping("/{cardId}")
    public DtoCard buscarCard( @PathVariable Long cardId){
        return cardConvertAssembler
                .convert_para_DTO(service.buscarPorId(cardId));
    }

    @GetMapping("/buscarTitulo/{titulo}")
    public List<DtoCard> buscarPorTitulo(@PathVariable String titulo){
        return cardConvertAssembler.toCollectionDTO(service.buscarPorTitulo(titulo));
    }

    @GetMapping("/buscarTodos")
    public List<DtoCard> buscarTodos(){
        return cardConvertAssembler.toCollectionDTO(service.buscarTodos());
    }

//    @PostMapping("/criarCard")
//    @ResponseStatus(HttpStatus.CREATED)
//    public DtoCard criarCard(@RequestBody CardInput cardInput){
//        return cardConvertAssembler
//                .convert_para_DTO(service.save(
//                        cardConvertDISAssembler.convert_paraClienteDomain(cardInput)
//                ));
//    }

    @PostMapping
    public void criarAutomaticCard(String descricao, String titulo){
        CardInput cardInput = new CardInput(descricao, titulo);
        service.saveAutomatic(cardConvertDISAssembler.convert_paraClienteDomain(cardInput));
    }

}
