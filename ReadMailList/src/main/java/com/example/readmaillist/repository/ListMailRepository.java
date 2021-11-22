package com.example.readmaillist.repository;

import com.example.readmaillist.model.MailList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListMailRepository extends JpaRepository<MailList, Long> {
}
