package com.libraapps.giftcard.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GiftCardParameterResolverTest {

    @Autowired
    GiftCardParameterResolver giftCardParameterResolver;

    @Test
    void testParams() {

        assertAll(
                ()->assertTrue(giftCardParameterResolver.getGiftCard(10).getMaxValue().equals(5000)),
                ()->assertTrue(giftCardParameterResolver.getGiftCardsKeys().contains(50))
        );


    }

}