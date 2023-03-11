package org.example.controller;

import org.example.base.BaseResult;
import org.example.model.card.Card;
import org.example.model.request.ChargeParam;
import org.example.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vi/charge")
public class ChargeController {

    @Autowired
    ChargeService chargeService;

    @PostMapping("/generate")
    public Object generate(@RequestBody ChargeParam param) {
        List<Card> list = chargeService.generate(param.type, param.number, param.validate);
        return BaseResult.success(list);
    }

    @PostMapping("/all")
    public Object getAll(@RequestBody Map<String,Object> param) {

        List<Card> list = chargeService.getAll(param);
        return BaseResult.success(list);
    }

}

