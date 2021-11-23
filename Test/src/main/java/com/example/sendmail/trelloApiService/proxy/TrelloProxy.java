package com.example.sendmail.trelloApiService.proxy;

import com.example.sendmail.trelloApiService.model.CardInput;
import com.fasterxml.jackson.annotation.JsonProperty;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "trello-service") //endpoint do cliente/microserviço a ser acessado
public interface TrelloProxy {

    @PostMapping(value = "trello-service") //TODO sem barra
    void criarAutomaticCard(@RequestBody CardInput cardInput);


}
