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
            msgErro.printStackTrace(); //TODO substituir por handler
        }
        return emailSalvo;
    }

    private void enviarEmail(Mail mail) throws MessagingException, UnsupportedEncodingException {
        JavaMailSenderImpl factorMail = new JavaMailSenderImpl();

        factorMail.setHost("smtp.gmail.com");
        factorMail.setPort(587);
        factorMail.setUsername("crvedgartest@gmail.com");
        factorMail.setPassword("pcpqzzntzuwndcpw"); // TODO senha real

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
        System.out.println("AMEM, EMAIL ENVIADO - VERIFICAR CX DE ENTRADA: \n " + mail.getCorpo());
        //TODO inserir no logger
    }
}
