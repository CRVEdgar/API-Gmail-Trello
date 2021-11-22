package com.example.sendmail.trelloApiService.proxy;

import com.example.sendmail.trelloApiService.model.CardInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "trello-service") //endpoint do cliente/microserviço a ser acessado
public interface TrelloProxy {

    @PostMapping
    public void criarAutomaticCard(/*@RequestBody*/ CardInput cardInput);


}
