package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.GiftCardDto;
import com.libraapps.giftcard.repository.GiftCardRepository;


import java.util.List;

//@Component
//@Scope(
//        value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Repositor extends Thread {

    private static GiftCardRepository giftCardRepository;
    private Boolean aBoolean;

    //    @Autowired
    public Repositor(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
        this.aBoolean = true;
    }


    public static synchronized void refill() {
        List<GiftCardDto> toFill = giftCardRepository.getAll();
        for (int i = 0; i < toFill.size(); i++) {
            if (toFill.get(i).getValue() < toFill.get(i).getMinValue()) {
                toFill.get(i).addValue(toFill.get(i).getMaxValue() - toFill.get(i).getValue());
            }
        }

    }

    public void setaBoolean(Boolean b) {
        this.aBoolean = b;
    }

    @Override
    public void run() {
        while (this.aBoolean) {
            this.refill();
        }
    }
}
