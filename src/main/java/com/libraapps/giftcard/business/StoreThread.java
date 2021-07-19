package com.libraapps.giftcard.business;

public class StoreThread extends Thread{

    private Repositor repositor;


    public StoreThread(Repositor repositor) {
        this.repositor = repositor;
    }

    @Override
    public void run() {
        while (true) {
            this.repositor.refill();
        }
    }


}
