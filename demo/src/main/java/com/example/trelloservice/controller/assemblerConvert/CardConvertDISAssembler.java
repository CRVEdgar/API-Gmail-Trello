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

    //recebe um objeto input e convert para um objeto do modelo de domínio
    public Card convert_paraClienteDomain(CardInput cardInput){
        return modelMapper.map(cardInput, Card.class);
    }

    public void copy_paraClienteDomain(CardInput cardInput, Card card){
        modelMapper.map(cardInput, card);
    }
}
