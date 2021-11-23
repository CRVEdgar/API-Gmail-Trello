package com.example.trelloservice.controller.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class CardInput implements Serializable {

    private static final long serialVersionUID = 1L;

    private String descricao;
    private String titulo;
}
