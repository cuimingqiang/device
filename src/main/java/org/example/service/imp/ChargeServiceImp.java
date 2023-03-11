package org.example.service.imp;

import org.example.model.card.Card;
import org.example.repository.ChargeRepository;
import org.example.service.ChargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChargeServiceImp implements ChargeService {
    private final static Logger logger = LoggerFactory.getLogger(ChargeServiceImp.class);
    Random randObj = new Random();
    @Autowired
    ChargeRepository chargeRepository;

    @Override
    public List<Card> generate(int type, int number, int validate) {
        int length = number;
        if (length < 1) length = 1;
        List<Card> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            Card card = new Card();
            card.cardNo = UUID.randomUUID().toString().replace("-", "")
                    .substring(0, 10)
                    .toUpperCase();
            card.cardPassword = Integer.toString(100000 + randObj.nextInt(900000));
            card.createDate = new Date();
            card.type = type;
            card.validity = validate;
            list.add(card);
        }
        return chargeRepository.saveAll(list);
    }


    @Override
    public List<Card> getAll(Map<String, Object> param) {
        int type = (int) param.get("type");
        int active = (int) param.get("active");
        logger.info("[charge get all]{}|{}", type, active);
        return chargeRepository.getCardByTypeAndIsUsed(type, active);
    }

    @Override
    public Card getCard(String cardNO, String verify) {

        return chargeRepository.findCard(cardNO,verify);
    }

    @Override
    public void active(Card card) {
        chargeRepository.save(card);
    }
}
