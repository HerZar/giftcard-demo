package com.libraapps.giftcard.controler;


import com.libraapps.giftcard.business.*;
import com.libraapps.giftcard.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class StoreControler {

    @Autowired
    GiftCardRepository giftCardRepository;

    public StoreControler() {
    }


    public void storeProcess() throws InterruptedException {

        Extractor extractor1 = new Extractor(giftCardRepository);
        Repositor repositor1 = new Repositor(giftCardRepository);


        StoreExtThread storeExtThread1 = new StoreExtThread(extractor1);
        StoreExtThread storeExtThread2 = new StoreExtThread(extractor1);

        StoreThread storeThread1 = new StoreThread(repositor1);
        StoreThread storeThread2 = new StoreThread(repositor1);
        StoreThread storeThread3 = new StoreThread(repositor1);
        StoreThread storeThread4 = new StoreThread(repositor1);
        StoreThread storeThread5 = new StoreThread(repositor1);
        StoreThread storeThread6 = new StoreThread(repositor1);
        StoreThread storeThread7 = new StoreThread(repositor1);
        StoreThread storeThread8 = new StoreThread(repositor1);
        StoreThread storeThread9 = new StoreThread(repositor1);
        StoreThread storeThread0 = new StoreThread(repositor1);
        StoreThread storeThread11 = new StoreThread(repositor1);
        StoreThread storeThread12 = new StoreThread(repositor1);
        StoreThread storeThread13 = new StoreThread(repositor1);
        StoreThread storeThread14 = new StoreThread(repositor1);
        StoreThread storeThread15 = new StoreThread(repositor1);
        StoreThread storeThread16 = new StoreThread(repositor1);
        StoreThread storeThread17 = new StoreThread(repositor1);
        StoreThread storeThread18 = new StoreThread(repositor1);
        StoreThread storeThread19 = new StoreThread(repositor1);
        StoreThread storeThread10 = new StoreThread(repositor1);
        storeThread1.start();
        storeThread2.start();
        storeThread3.start();
        storeThread4.start();
        storeThread5.start();
        storeThread6.start();
        storeThread7.start();
        storeThread8.start();
        storeThread9.start();
        storeThread0.start();
        storeThread11.start();
        storeThread12.start();
        storeThread13.start();
        storeThread14.start();
        storeThread15.start();
        storeThread16.start();
        storeThread17.start();
        storeThread18.start();
        storeThread19.start();
        storeThread10.start();



        storeExtThread1.start();
        storeExtThread2.start();


        Observer observer = new Observer(giftCardRepository);
        observer.start();



    }


}
