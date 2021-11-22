package com.example.trelloservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_card")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String titulo;
}
