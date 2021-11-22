package com.example.trelloservice.exception;

public class ServiceExceptionCard extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceExceptionCard(String mensagem){
        super(mensagem);
    }

    public ServiceExceptionCard(String mensagem, Throwable causa){
        super(mensagem, causa);
    }

}
