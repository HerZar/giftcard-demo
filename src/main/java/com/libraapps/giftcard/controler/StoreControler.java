package com.libraapps.giftcard.controler;


import com.libraapps.giftcard.business.Extractor;
import com.libraapps.giftcard.business.Observer;
import com.libraapps.giftcard.business.Repositor;
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
        Extractor extractor2 = new Extractor(giftCardRepository);
        Extractor extractor3 = new Extractor(giftCardRepository);
        Extractor extractor4 = new Extractor(giftCardRepository);
        Extractor extractor5 = new Extractor(giftCardRepository);
        Extractor extractor6= new Extractor(giftCardRepository);
        Extractor extractor7 = new Extractor(giftCardRepository);
        Extractor extractor8 = new Extractor(giftCardRepository);

        Repositor repositor1 = new Repositor(giftCardRepository);
        Repositor repositor2 = new Repositor(giftCardRepository);
        Repositor repositor3 = new Repositor(giftCardRepository);
        Repositor repositor4 = new Repositor(giftCardRepository);
        Repositor repositor5 = new Repositor(giftCardRepository);
        Repositor repositor6 = new Repositor(giftCardRepository);
        Repositor repositor7 = new Repositor(giftCardRepository);
        Repositor repositor8 = new Repositor(giftCardRepository);
        Repositor repositor9 = new Repositor(giftCardRepository);
        Repositor repositor10 = new Repositor(giftCardRepository);
        Repositor repositor11 = new Repositor(giftCardRepository);
        Repositor repositor12 = new Repositor(giftCardRepository);
        Repositor repositor13 = new Repositor(giftCardRepository);
        Repositor repositor14 = new Repositor(giftCardRepository);
        Repositor repositor15 = new Repositor(giftCardRepository);

        Observer observer = new Observer(giftCardRepository);

        extractor1.start();
        extractor2.start();
        extractor3.start();
        extractor4.start();
        extractor5.start();
        extractor6.start();
        extractor7.start();
        extractor8.start();

        repositor1.start();
        repositor2.start();
        repositor3.start();
        repositor4.start();
        repositor5.start();
        repositor6.start();
        repositor7.start();
        repositor8.start();
        repositor9.start();
        repositor10.start();
        repositor11.start();
        repositor12.start();
        repositor13.start();
        repositor14.start();
        repositor15.start();

        observer.start();



    }


}
