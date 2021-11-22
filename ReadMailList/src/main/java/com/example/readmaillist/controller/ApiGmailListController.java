package com.example.readmaillist.controller;

import com.example.readmaillist.model.MailList;
import com.example.readmaillist.repository.ListMailRepository;
import com.example.readmaillist.service.MailListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "https://gmail.googleapis.com/gmail/v1/users/me/messages")
public class ApiGmailListController {

    @Autowired
    private MailListService service;

    @GetMapping
    public void buscar(@RequestBody MailList mailList){
        Integer quantidadeEmails = mailList.getResultSizeEstimate();

        Integer quantidadeBanco = service.consultar();

        if(quantidadeEmails > quantidadeBanco){
            System.out.println("Mais emais que no banco!");
        }
    }



}
