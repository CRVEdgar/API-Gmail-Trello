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

    private final long ciclo_5_Min = 1*(1000 * 60);
//    private static Integer qtdAnterior = 0;
//    private static Integer qtdAtual = 0;
//
//    verificaPorHora(qtdAnterior, qtdAtual);

    @Scheduled(fixedDelay = ciclo_5_Min)
    public void verificaPorHora() {
//        if(!(qtdAnterior == 0 && qtdAtual == 0)){
//            if(qtdAnterior == 0){
//                qtdAnterior = service.quantidade();
//                qtdAtual = service.quantidade();
//            }else{
//                qtdAtual = service.quantidade();
//                if(qtdAtual>qtdAnterior){
//                    qtdAnterior = qtdAtual;
//                    System.out.println("QTD ANTERIOR: " + qtdAnterior);
//                }
//            }
//        }
        System.out.println("***** MONITORANDO A CX DE ENTRADA *****");
        System.out.println("VERIFICAÇÃO FEITA EM: " + LocalDateTime.now());
        System.out.println("QUANTIDADE DE EMAILS NA CX DE ENTRADA: " + service.quantidade());
    }
}
