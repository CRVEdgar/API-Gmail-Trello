package com.example.readmaillist.Exception;

public class ServiceExceptionMail extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceExceptionMail(String mensagem){
        super(mensagem);
    }

    public ServiceExceptionMail(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
