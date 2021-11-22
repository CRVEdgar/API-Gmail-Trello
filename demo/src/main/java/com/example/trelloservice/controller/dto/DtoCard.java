package com.example.trelloservice.controller.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DtoCard {

    private Long id;
    private String descricao;
    private String titulo;
}
