package com.example.sendmail.service;

import com.example.sendmail.Repository.MailRepository;
import com.example.sendmail.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SendMailService {

    @Autowired
    private MailRepository repository;

    @Transactional
    public Mail save(Mail mail) {
        return repository.save(mail);
    }
}
