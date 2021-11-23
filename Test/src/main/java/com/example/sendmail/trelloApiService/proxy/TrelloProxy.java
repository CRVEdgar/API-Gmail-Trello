package com.example.sendmail.trelloApiService.proxy;

import com.example.sendmail.trelloApiService.model.CardInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "trello-service")
public interface TrelloProxy {

    @PostMapping(value = "trello-service") //TODO sem barra
    void criarAutomaticCard(@RequestBody CardInput cardInput);

}
