package com.example.readmaillist.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_qtdmail")
@Getter
@Setter
public class MailList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "mailList")
    private List<messages> messagesList = new ArrayList<>();

    private Integer resultSizeEstimate;
}
