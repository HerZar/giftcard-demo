package com.libraapps.giftcard.repository.impl;

import com.libraapps.giftcard.model.GiftCardDto;
import com.libraapps.giftcard.util.GiftCardParameterResolver;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GiftCardRespositoryImplTest {

    @Mock
    GiftCardParameterResolver giftCardParameterResolver;

    GiftCardRespositoryImpl giftCardRespository;

    @Test
    void getAll() {

        Map<Integer, GiftCardDto> cardsMap = new HashMap<>();
        cardsMap.put(10,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(10).build());
        cardsMap.put(20,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(20).build());
        cardsMap.put(50,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(50).build());
        cardsMap.put(100, GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(1000).build());

        when(this.giftCardParameterResolver.getAllCard()).thenReturn(cardsMap);

        giftCardRespository = new GiftCardRespositoryImpl(giftCardParameterResolver);

        List<GiftCardDto> result =  this.giftCardRespository.getAll();

        assertTrue( result.size() == 4);

    }

    @Test
    void getByDiscount() {

        Map<Integer, GiftCardDto> cardsMap = new HashMap<>();
        cardsMap.put(10,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(10).build());
        cardsMap.put(20,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(20).build());
        cardsMap.put(50,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(50).build());
        cardsMap.put(100, GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(1000).build());

        when(this.giftCardParameterResolver.getAllCard()).thenReturn(cardsMap);

        giftCardRespository = new GiftCardRespositoryImpl(giftCardParameterResolver);

        GiftCardDto res = this.giftCardRespository.getByDiscount(50);
        GiftCardDto expected = GiftCardDto.builder().discount(50).maxValue(5000).minValue(1000).value(5000).build();

        assertEquals(expected,res);

    }

    @Test
    void updateGiftCard() {

        Map<Integer, GiftCardDto> cardsMap = new HashMap<>();
        cardsMap.put(10,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(10).build());
        cardsMap.put(20,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(20).build());
        cardsMap.put(50,  GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(50).build());
        cardsMap.put(100, GiftCardDto.builder().value(5000).minValue(1000).maxValue(5000).discount(1000).build());

        when(this.giftCardParameterResolver.getAllCard()).thenReturn(cardsMap);

        giftCardRespository = new GiftCardRespositoryImpl(giftCardParameterResolver);
        GiftCardDto expected = GiftCardDto.builder().discount(50).maxValue(5000).minValue(1000).value(2000).build();
        GiftCardDto res = this.giftCardRespository.getByDiscount(50);
        assertTrue(res.getValue()!= expected.getValue());
        this.giftCardRespository.updateGiftCard(expected);
        res = this.giftCardRespository.getByDiscount(50);
        assertEquals(expected,res);

    }
}