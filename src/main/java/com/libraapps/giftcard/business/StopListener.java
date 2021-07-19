package com.libraapps.giftcard.business;

import com.libraapps.giftcard.model.Stop;

import java.util.Scanner;

public class StopListener implements Runnable{

    private Stop stop;

    public StopListener(Stop stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        System.out.println("PRESS ENTER KEY TO STOP");
        Scanner in = new Scanner(System.in);

        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
        stop.stop();
    }
}
