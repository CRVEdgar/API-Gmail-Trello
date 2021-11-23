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

    public Mail convert_paraEmailDomain(MailInput mailInput){
        return modelMapper.map(mailInput, Mail.class);
    }

    public void copy_paraMailDomain(MailInput mailInput, Mail mail){
        modelMapper.map(mailInput, mail);
    }
}
