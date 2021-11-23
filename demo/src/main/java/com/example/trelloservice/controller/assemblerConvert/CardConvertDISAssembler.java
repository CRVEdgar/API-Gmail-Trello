package com.example.trelloservice.controller.assemblerConvert;

import com.example.trelloservice.controller.input.CardInput;
import com.example.trelloservice.model.Card;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * CLASSE UTILIZADA PARA CONVERTER CardInput em Card para depois enviar ao Service
 * */

@Component
public class CardConvertDISAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public Card convert_paraCardDomain(CardInput cardInput){
        return modelMapper.map(cardInput, Card.class);
    }

    public void copy_paraCardDomain(CardInput cardInput, Card card){
        modelMapper.map(cardInput, card);
    }
}
