package com.libraapps.giftcard.business;

public class StoreExtThread extends Thread{

    private Extractor extractor;


    public StoreExtThread(Extractor extractor) {
        this.extractor = extractor;
    }

    @Override
    public void run() {
        while (true) {
            this.extractor.giveACards();
        }
    }


}
