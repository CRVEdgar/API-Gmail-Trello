package com.example.trelloservice.controller.assemblerConvert;


import com.example.trelloservice.controller.dto.DtoCard;
import com.example.trelloservice.model.Card;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/*
 * CLASSE UTILIZADA PARA CONVERTER CArd em CardDto para depois devolver ao controller
 * */

@Component
public class CardConvertAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public DtoCard convert_para_DTO(Card card){
        return modelMapper.map(card, DtoCard.class);
    }

    public List<DtoCard> toCollectionDTO(List<Card> cards){

        return cards.stream()
                .map(card -> convert_para_DTO(card))
                .collect(Collectors.toList());
    }
}
