package com.example.sendmail.controller;

import com.example.sendmail.controller.assemblerConvert.MailConvertAssembler;
import com.example.sendmail.controller.assemblerConvert.MailConvertDISAssembler;
import com.example.sendmail.controller.dto.DtoMail;
import com.example.sendmail.controller.input.MailInput;
import com.example.sendmail.service.SendMailService;
import com.example.sendmail.trelloApiService.model.CardInput;
import com.example.sendmail.trelloApiService.proxy.TrelloProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "sendmail-service")
public class MailController {

    @Autowired
    private SendMailService service;

    @Autowired
    private MailConvertAssembler mailConvertAssembler;

    @Autowired
    private MailConvertDISAssembler mailConvertDISAssembler;

    @Autowired
    private TrelloProxy proxy;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DtoMail enviar(@RequestBody @Valid MailInput mailInput){
        return salvarNoBanco(mailInput);
    }

    private DtoMail salvarNoBanco(MailInput mailInput){
        DtoMail emailSalvo = mailConvertAssembler
                .convert_para_DTO(service.save(
                        mailConvertDISAssembler.convert_paraEmailDomain(mailInput)
                ));

        salvarCard(mailInput.getTitulo(), mailInput.getCorpo());

        return emailSalvo;
    }

    /********SALVANDO CARD NA API trello-service********/

    private void salvarCard(String titulo, String corpo){
        String tituloMinusculo = titulo.toLowerCase();
        String corpoMinusculo = corpo.toLowerCase();

        if(tituloMinusculo.contains("trello") || corpoMinusculo.contains("trello")){
            CardInput cardInput = new CardInput(corpo, titulo);

            proxy.criarAutomaticCard(cardInput);

        }
    }

}
