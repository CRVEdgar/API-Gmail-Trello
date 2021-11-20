package com.example.sendmail.Repository;

import com.example.sendmail.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Long> {
}
