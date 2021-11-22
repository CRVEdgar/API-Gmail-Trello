package com.example.trelloservice.repository;

import com.example.trelloservice.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByDescricaoContainingIgnoreCase(String descricao);

    List<Card> findAllByTituloContainingIgnoreCase(String titulo);
}
