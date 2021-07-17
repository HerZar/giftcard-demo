package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.GiftCardDto;
import com.libraapps.giftcard.repository.GiftCardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositorTest {

    @Autowired
    Repositor repositor;
    @Autowired
    GiftCardRepository giftCardRepository;

    @Test
    void refill() {

        List<GiftCardDto> lista  = giftCardRepository.getAll();

        lista.forEach(g->{
            g.setValue(10);
        });

        repositor.refill();


        assertTrue(true);

    }
}