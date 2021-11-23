package com.example.sendmail.controller;

import com.example.sendmail.controller.assemblerConvert.MailConvertAssembler;
import com.example.sendmail.controller.assemblerConvert.MailConvertDISAssembler;
import com.example.sendmail.controller.dto.DtoMail;
import com.example.sendmail.controller.input.MailInput;
import com.example.sendmail.service.SendMailService;
import com.example.sendmail.trelloApiService.model.CardInput;
import com.example.sendmail.trelloApiService.proxy.TrelloProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "sendmail-service")
public class MailController {

    @Autowired
    private SendMailService service;

    @Autowired
    private MailConvertAssembler mailConvertAssembler;

    @Autowired
    private MailConvertDISAssembler mailConvertDISAssembler;

    @Autowired
    private Environment environment;

    @Autowired
    private TrelloProxy proxy;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DtoMail enviar(@RequestBody @Valid MailInput mailInput){
        salvarCard(mailInput.getTitulo(), mailInput.getCorpo()); //TODO trocar por string

        return salvarNoBanco(mailInput);
//        return mailConvertAssembler
//                .convert_para_DTO(service.save(
//                        mailConvertDISAssembler.convert_paraClienteDomain(mailInput)
//                ));
    }

    private DtoMail salvarNoBanco(MailInput mailInput){
        DtoMail emailSalvo = mailConvertAssembler
                .convert_para_DTO(service.save(
                        mailConvertDISAssembler.convert_paraEmailDomain(mailInput)
                ));

//        salvarCard(mailInput.getTitulo(), mailInput.getCorpo());

        return emailSalvo;
    }

    /********SALVANDO CARD NA API trello-service********/

    private void salvarCard(String titulo, String corpo){
        String tituloMinusculo = titulo.toLowerCase();
        String corpoMinusculo = corpo.toLowerCase();

        if(tituloMinusculo.contains("trello") || corpoMinusculo.contains("trello")){
            CardInput cardInput = new CardInput(corpo, titulo);
            System.out.println("CORPO: " + cardInput.getDescricao());
            System.out.println("CORPO: " + cardInput.getTitulo());

            proxy.criarAutomaticCard(corpo, titulo);

//            var mailVar = mailSend; //TODO Implementar o Enviroment // receber o valor vindo do banco
//
//            var card = cardInput; //TODO Implementar o Enviroment no trello-service // receber o valor vindo do serviço
//
//            var port = environment.getProperty("local.server.port");
//
//            mailVar.setEnvironment("book port: " +port + " || Cambio Port: " + card.getEnviroment());

        }
    }

}
