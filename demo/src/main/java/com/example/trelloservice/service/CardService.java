package com.example.trelloservice.service;

import com.example.trelloservice.model.Card;
import com.example.trelloservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    @Transactional
    public Card criar(Card cardInput){
        return repository.save(cardInput);
    }

    public Card buscarPorNomeOuId(Long id, String descricao){
//        if(){
//
//        }else if(){
//
//        }

        return null;
    }
}
