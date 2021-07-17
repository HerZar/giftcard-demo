package com.libraapps.giftcard.repository.impl;

import com.libraapps.giftcard.model.GiftCardDto;
import com.libraapps.giftcard.repository.GiftCardRepository;
import com.libraapps.giftcard.util.GiftCardParameterResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class GiftCardRespositoryImpl implements GiftCardRepository {

    private Map<Integer, GiftCardDto> giftParameters;

    @Autowired
    public GiftCardRespositoryImpl(GiftCardParameterResolver giftCardParameterResolver) {
        this.giftParameters = giftCardParameterResolver.getAllCard();
    }

    @Override
    public List<GiftCardDto> getAll() {
        List<GiftCardDto> list = this.giftParameters.values().stream().collect(Collectors.toList());
        return list;
    }

    @Override
    public GiftCardDto getByDiscount(Integer discount) {
        return this.giftParameters.get(discount);
    }

    @Override
    public void updateGiftCard(GiftCardDto giftCardDto) {
        this.giftParameters.put(giftCardDto.getDiscount(), giftCardDto);
    }
}
