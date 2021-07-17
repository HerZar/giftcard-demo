package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.GiftCardDto;
import com.libraapps.giftcard.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(
        value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Repositor extends Thread implements IRespositor{

    private GiftCardRepository giftCardRepository;
    private Boolean aBoolean;
    @Autowired
    public Repositor(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
        this.aBoolean = true;
    }


    @Override
    public void refill() {
        List<GiftCardDto> toFill = this.giftCardRepository.getAll();
        toFill.forEach(giftCardDto -> {
            if (giftCardDto.getValue()<giftCardDto.getMinValue()){
                giftCardDto.addValue(giftCardDto.getMaxValue()-giftCardDto.getValue());
            }
        });
    }

    public void setaBoolean(Boolean b){
        this.aBoolean =b;
    }

    @Override
    public void run() {
        while (this.aBoolean) {
            this.refill();
            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
