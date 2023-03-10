package org.example.service;

import org.example.model.card.Card;

import java.util.List;
import java.util.Map;

public interface ChargeService {

    List<Card> generate(int type,int number,int validate);


    List<Card> getAll(Map<String, Object> param);
}
