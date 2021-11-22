package com.example.trelloservice.controller;

import com.example.trelloservice.model.Card;
import com.example.trelloservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/total")
public class CardController {

    @Autowired
    private CardService service;

//    @GetMapping
//    public Card buscarCard(){
//        return service.buscarPorNomeOuId();
//    }
//
//    @PostMapping
//    public Card criarCard(){
//        return service.criar();
//    }


}
