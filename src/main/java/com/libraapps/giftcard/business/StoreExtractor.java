package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.Stop;

public class StoreExtractor implements Runnable{

    private Extractor extractor;
    private Stop stop;

    public StoreExtractor(Extractor extractor, Stop run) {
        this.extractor = extractor;
        this.stop = run;
    }

    @Override
    public void run() {
        while (!stop.toStop()) {
            this.extractor.giveACards();
        }
    }


}
