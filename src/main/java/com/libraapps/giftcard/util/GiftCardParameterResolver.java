package com.libraapps.giftcard.util;


import com.fasterxml.jackson.databind.json.JsonMapper;
import com.libraapps.giftcard.model.GiftCardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class GiftCardParameterResolver {


    private Map<Integer, GiftCardDto> giftParameters;

    @Autowired
    public GiftCardParameterResolver() {
        try {
            GiftCardDto[] giftCardsParamDTOS = JsonMapper.builder().build().readValue(new ClassPathResource("giftcardsConfig.json").getInputStream(), GiftCardDto[].class);
            giftParameters = new HashMap<>();
            Arrays.asList(giftCardsParamDTOS).forEach((giftCard)->{
                giftParameters.put(giftCard.getDiscount(), giftCard);
            });
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error("Error GiftCardParameterResolver Inicialization", e);
        }
    }

    public Map<Integer, com.libraapps.giftcard.model.GiftCardDto> getAllCard(){
        return giftParameters;
    }

    public GiftCardDto getGiftCard(Integer giftCardKey){
        return giftParameters.get(giftCardKey);
    }

    public List<Integer> getGiftCardsKeys(){
        return giftParameters.keySet().stream().collect(Collectors.toList());
    }

}
