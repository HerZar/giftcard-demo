package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.GiftCardDto;
import com.libraapps.giftcard.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//@Scope(
//        value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Extractor{

    private GiftCardRepository giftCardRepository;

//    @Autowired
    public Extractor(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
    }

    public synchronized void giveACards() {

        List<GiftCardDto> toFill = this.giftCardRepository.getAll();
        toFill.forEach(giftCardDto -> {
                if (giftCardDto.getValue()>100) {
                    giftCardDto.subtractValue(100);
                }else{
                    giftCardDto.subtractValue(giftCardDto.getValue());
                }
        });
    }

}
