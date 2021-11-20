package com.example.sendmail.controller.assemblerConvert;

import com.example.sendmail.controller.dto.DtoMail;
import com.example.sendmail.model.Mail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * CLASSE UTILIZADA PARA CONVERTER Mail em MailDTO para depois devolver ao controller
 * */

@Component
public class MailConvertAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public DtoMail convert_para_DTO(Mail mail){
        return modelMapper.map(mail, DtoMail.class);
    }


}
