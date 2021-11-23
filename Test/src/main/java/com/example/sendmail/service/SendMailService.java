package com.example.sendmail.service;

import com.example.sendmail.Repository.MailRepository;
import com.example.sendmail.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Service
public class SendMailService {

    @Autowired
    private MailRepository repository;

    @Transactional
    public Mail save(Mail mail) {
        Mail emailSalvo = repository.save(mail);

        try{
            enviarEmail(emailSalvo);
        } catch (UnsupportedEncodingException | MessagingException msgErro){
            msgErro.printStackTrace();
        }
        return emailSalvo;
    }

    public Integer quantidade(){
        Integer qtd = Math.toIntExact(repository.count());
        return qtd;
    }

    private void enviarEmail(Mail mail) throws MessagingException, UnsupportedEncodingException {
        JavaMailSenderImpl factorMail = new JavaMailSenderImpl();

        factorMail.setHost("smtp.gmail.com");
        factorMail.setPort(587);
        factorMail.setUsername("crvedgartest@gmail.com");
        factorMail.setPassword("pcpqzzntzuwndcpw");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        factorMail.setJavaMailProperties(properties);

        MimeMessage message = factorMail.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(mail.getRemetente(), "Edgar-Test");
        helper.setTo(mail.getDestinatario());
        helper.setSubject(mail.getTitulo());

        helper.setText(mail.getCorpo(), true);

        factorMail.send(message);

        System.out.println("EMAIL ENVIADO - VERIFICAR CX DE ENTRADA: \n " + mail.getCorpo());

    }
}
