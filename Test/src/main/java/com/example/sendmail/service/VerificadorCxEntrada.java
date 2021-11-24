package com.example.sendmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class VerificadorCxEntrada {
    @Autowired
    private SendMailService service;

    private final long ciclo_3_Min = 3*(1000 * 60);

    @Scheduled(fixedDelay = ciclo_3_Min)
    public void verificaPorHora() {

        System.out.println("***** MONITORANDO A CX DE ENTRADA *****");
        System.out.println("VERIFICAÇÃO FEITA EM: " + LocalDateTime.now());
        System.out.println("QUANTIDADE DE EMAILS NA CX DE ENTRADA: " + service.quantidade());
    }
}
