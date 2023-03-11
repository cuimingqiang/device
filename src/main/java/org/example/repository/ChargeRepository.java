package org.example.repository;

import org.example.model.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Card, Long> {

    @Query("SELECT T FROM Card T WHERE type = :type AND isUsed = :active AND validity = :validity")
    List<Card> getCardByTypeAndIsUsed(Integer type, Integer active, int validity);

    @Query("SELECT T FROM Card T WHERE cardNo = :cardNo AND cardPassword = :password")
    Card findCard(String cardNo, String password);
}
