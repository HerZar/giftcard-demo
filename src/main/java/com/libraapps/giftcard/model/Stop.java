package com.libraapps.giftcard.model;

import lombok.Data;

public class Stop {

    boolean stop;

    public Stop() {
        this.stop = false;
    }

    public boolean toStop(){
        return this.stop;
    }

    public void stop(){
        this.stop = true;
    }

}
