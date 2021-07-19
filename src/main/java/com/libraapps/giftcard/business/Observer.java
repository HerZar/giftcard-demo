package com.libraapps.giftcard.business;

import com.libraapps.giftcard.repository.GiftCardRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//@Component
//@Scope(
//        value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Observer extends Thread implements IObserver{

    private static final String TAB= "\t";
    private static final String ALERT= "ALERT";
    private GiftCardRepository giftCardRepository;
    private Boolean aBoolean;

    public Observer(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
        aBoolean = true;
    }

    @Override
    public void displayBagsStatus() {

        this.giftCardRepository.getAll().forEach(gift ->{
            System.out.print(TAB+gift.getDiscount()+TAB+TAB+TAB);
        });
        System.out.println("");
        this.giftCardRepository.getAll().forEach(gift ->{
            System.out.print(TAB+gift.getValue()+TAB);
            if (gift.getValue()>gift.getMaxValue()){
                System.out.print(ALERT+TAB);
            }else{
                System.out.print(TAB+TAB);
            }
        });
        System.out.println("");

    }

    public void setaBoolean(Boolean b){
        this.aBoolean =b;
    }

    @Override
    public void run() {
        while (this.aBoolean) {
            this.displayBagsStatus();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
