package com.libraapps.giftcard.repository.impl;

import com.libraapps.giftcard.model.GiftCardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GiftCardRespositoryImplTest {

    @Autowired
    GiftCardRespositoryImpl giftCardRespository;

    @Test
    void getAll() {

        List<GiftCardDto> result =  this.giftCardRespository.getAll();

        assertTrue( result.size() == 4);

    }

    @Test
    void getByDiscount() {

        GiftCardDto res = this.giftCardRespository.getByDiscount(50);
        GiftCardDto expected = GiftCardDto.builder().discount(50).maxValue(5000).minValue(1000).value(5000).build();

        assertEquals(expected,res);

    }

    @Test
    void updateGiftCard() {

        GiftCardDto expected = GiftCardDto.builder().discount(50).maxValue(5000).minValue(1000).value(2000).build();
        GiftCardDto res = this.giftCardRespository.getByDiscount(50);
        assertTrue(res.getValue()!= expected.getValue());
        this.giftCardRespository.updateGiftCard(expected);
        res = this.giftCardRespository.getByDiscount(50);
        assertEquals(expected,res);

    }
}