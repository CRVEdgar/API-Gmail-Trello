package com.example.sendmail.controller.dto;

import lombok.*;


@Getter
@Setter
public class DtoMail {

    private String remetente;
    private String destinatario;
    private String titulo;
    private String corpo;
}
