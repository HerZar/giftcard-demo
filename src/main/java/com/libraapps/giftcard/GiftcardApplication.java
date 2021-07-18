package com.libraapps.giftcard;


import com.libraapps.giftcard.controler.StoreControler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GiftcardApplication implements CommandLineRunner {

    @Autowired
    private StoreControler storeControler;

    public static void main(String[] args) {
        SpringApplication.run(GiftcardApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        storeControler.storeProcess();
    }
}
