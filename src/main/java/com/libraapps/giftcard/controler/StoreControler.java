package com.libraapps.giftcard.controler;


import com.libraapps.giftcard.business.Extractor;
import com.libraapps.giftcard.business.Observer;
import com.libraapps.giftcard.business.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public class StoreControler {


    public StoreControler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private ApplicationContext applicationContext;

    public void storeProcess() throws InterruptedException {

        Extractor extractor1 = applicationContext.getBean(Extractor.class);
        Extractor extractor2 = applicationContext.getBean(Extractor.class);
        Extractor extractor3 = applicationContext.getBean(Extractor.class);
        Extractor extractor4 = applicationContext.getBean(Extractor.class);

        Repositor repositor1 = applicationContext.getBean(Repositor.class);
        Repositor repositor2 = applicationContext.getBean(Repositor.class);
        Repositor repositor3 = applicationContext.getBean(Repositor.class);
        Repositor repositor4 = applicationContext.getBean(Repositor.class);

        Observer observer = applicationContext.getBean(Observer.class);

        extractor1.start();
        extractor2.start();
        extractor3.start();
        extractor4.start();

        repositor1.start();
        repositor2.start();
        repositor3.start();
        repositor4.start();

        observer.start();



    }


}
