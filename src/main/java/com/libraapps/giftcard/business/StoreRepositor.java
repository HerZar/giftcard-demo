package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.Stop;

public class StoreRepositor implements Runnable {

    private Repositor repositor;
    private Stop stop;

    public StoreRepositor(Repositor repositor, Stop stop) {
        this.repositor = repositor;
        this.stop = stop;
    }

    @Override
    public void run() {
        while (!stop.toStop()) {
            this.repositor.refill();
        }
    }


}
