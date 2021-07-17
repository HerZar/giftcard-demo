package com.libraapps.giftcard.repository;

import com.libraapps.giftcard.model.GiftCardDto;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface GiftCardRepository {

    public List<GiftCardDto> getAll();

    public GiftCardDto getByDiscount(Integer discount);

    public void updateGiftCard(GiftCardDto giftCardDto);

}
