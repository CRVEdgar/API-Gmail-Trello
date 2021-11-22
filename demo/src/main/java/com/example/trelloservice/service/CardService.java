package com.example.trelloservice.service;

import com.example.trelloservice.controller.input.CardInput;
import com.example.trelloservice.exception.ServiceExceptionCard;
import com.example.trelloservice.model.Card;
import com.example.trelloservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    @Transactional
    public Card save(Card cardInput){
        return repository.save(cardInput);
    }

    @Transactional
    public void saveAutomatic(Card cardInput){
        repository.save(cardInput);
    }

    public Card buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ServiceExceptionCard("Card com id informado Inexistente"));

    }

    public List<Card> buscarPorTitulo(String titulo){
        return repository.findAllByTituloContainingIgnoreCase(titulo);
    }

    public List<Card> buscarTodos(){
        return repository.findAll();
    }
}
