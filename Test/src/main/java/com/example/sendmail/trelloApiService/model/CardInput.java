package com.example.sendmail.trelloApiService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardInput {

    private String descricao;
    private String titulo;

}
