package com.example.sendmail.controller.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class MailInput implements Serializable {

    private static final long serialVersionUID = 1L;

    @Email
    private String remetente;
    @Email
    private String destinatario;
    @NotBlank
    private String titulo;
    @NotBlank
    private String corpo;

}
