package com.example.readmaillist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_messages")
public class messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Transient
    private Object id;
    @Transient
    private Object threadId;

    @ManyToOne
    @JoinColumn(name = "emails")
    private MailList mailList;
}
