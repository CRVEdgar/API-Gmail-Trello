package com.example.sendmail.controller;

import com.example.sendmail.controller.assemblerConvert.MailConvertAssembler;
import com.example.sendmail.controller.assemblerConvert.MailConvertDISAssembler;
import com.example.sendmail.controller.dto.DtoMail;
import com.example.sendmail.controller.input.MailInput;
import com.example.sendmail.model.Mail;
import com.example.sendmail.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sendmail")
public class MailController {

    @Autowired
    private SendMailService service;

    @Autowired
    private MailConvertAssembler mailConvertAssembler;

    @Autowired
    private MailConvertDISAssembler mailConvertDISAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DtoMail enviar(@RequestBody @Valid MailInput mailInput){
        return mailConvertAssembler
                .convert_para_DTO(service.save(
                        mailConvertDISAssembler.convert_paraClienteDomain(mailInput)
                ));
    }

    /****************/


}
