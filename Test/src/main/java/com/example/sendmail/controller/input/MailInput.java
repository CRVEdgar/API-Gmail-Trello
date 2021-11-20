package com.example.sendmail.controller.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MailInput {

    @Email
    private String remetente;
    @Email
    private String destinatario;
    @NotBlank
    private String titulo;
    @NotBlank
    private String corpo;

}
