package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.GiftCardDto;
import com.libraapps.giftcard.repository.GiftCardRepository;


import java.util.List;

//@Component
//@Scope(
//        value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Repositor{

    private static GiftCardRepository giftCardRepository;

    //    @Autowired
    public Repositor(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;

    }


    public synchronized void refill() {
        List<GiftCardDto> toFill = giftCardRepository.getAll();
        for (int i = 0; i < toFill.size(); i++) {
            if (toFill.get(i).getValue() < toFill.get(i).getMinValue()) {
                toFill.get(i).addValue(toFill.get(i).getMaxValue() - toFill.get(i).getValue());
            }
        }

    }

}
