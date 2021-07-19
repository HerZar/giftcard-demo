package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.Stop;
import com.libraapps.giftcard.repository.GiftCardRepository;

public class Observer implements Runnable{

    private static final String TAB= "\t";
    private static final String ALERT= "ALERT";
    private GiftCardRepository giftCardRepository;
    private Stop stop;

    public Observer(GiftCardRepository giftCardRepository, Stop stop) {
        this.giftCardRepository = giftCardRepository;
        this.stop = stop;
    }

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

    @Override
    public void run() {
        while (!stop.toStop()) {
            this.displayBagsStatus();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
