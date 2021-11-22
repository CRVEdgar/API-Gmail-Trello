package com.example.readmaillist.service;

import com.example.readmaillist.Exception.ServiceExceptionMail;
import com.example.readmaillist.model.MailList;
import com.example.readmaillist.repository.ListMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MailListService {

    @Autowired
    private ListMailRepository repository;

    @Transactional
    public Integer consultar(){
        List<MailList> qtd = repository.findAll();
        if(qtd.isEmpty()){
            salvar();
            Integer quantidadeEmails = buscar();
            return quantidadeEmails;
        }else{
            Integer quantidadeEmails = buscar();
            return quantidadeEmails;
        }
    }

    private Integer buscar(){
        MailList retorno = repository.findById(1L)
                .orElseThrow(() -> new ServiceExceptionMail("Lista com codigo 1 não encontrado"));
        Integer quantidadeEmails = retorno.getResultSizeEstimate();
        return quantidadeEmails;
    }

    @Transactional
    public void salvar(){
        MailList id = new MailList();
        id.setResultSizeEstimate(0);
        repository.save(id);
    }
}
