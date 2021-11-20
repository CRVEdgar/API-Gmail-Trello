package com.example.sendmail.controller.assemblerConvert;

import com.example.sendmail.controller.input.MailInput;
import com.example.sendmail.model.Mail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * CLASSE UTILIZADA PARA CONVERTER MailInput em Mail para depois enviar ao Service
 * */

@Component
public class MailConvertDISAssembler {

    @Autowired
    private ModelMapper modelMapper;

    //recebe um objeto input e convert para um objeto do modelo de domínio
    public Mail convert_paraClienteDomain(MailInput mailInput){
        return modelMapper.map(mailInput, Mail.class);
    }

    public void copy_paraClienteDomain(MailInput mailInput, Mail mail){
        modelMapper.map(mailInput, mail);
    }
}
