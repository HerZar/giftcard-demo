package com.libraapps.giftcard.controler;


import com.libraapps.giftcard.business.*;
import com.libraapps.giftcard.model.Stop;
import com.libraapps.giftcard.repository.GiftCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreControler {

    @Autowired
    GiftCardRepository giftCardRepository;

    public StoreControler() {
    }

    public void storeProcess() throws InterruptedException {

        Extractor extractor = new Extractor(giftCardRepository);
        Repositor repositor = new Repositor(giftCardRepository);
        Stop stop = new Stop();

        new Thread(new StopListener(stop), "stoper").start();

        Runnable ext = new StoreExtractor(extractor, stop);
        Runnable rep = new StoreRepositor(repositor, stop);

        new Thread(ext, "Extractor 1").start();
        new Thread(ext, "Extractor 2").start();

        new Thread(rep, "Repositor 1").start();
        new Thread(rep, "Repositor 2").start();
        new Thread(rep, "Repositor 3").start();
        new Thread(rep, "Repositor 4").start();
        new Thread(rep, "Repositor 5").start();
        new Thread(rep, "Repositor 6").start();
        new Thread(rep, "Repositor 7").start();
        new Thread(rep, "Repositor 8").start();
        new Thread(rep, "Repositor 9").start();
        new Thread(rep, "Repositor 10").start();
        new Thread(rep, "Repositor 11").start();
        new Thread(rep, "Repositor 12").start();
        new Thread(rep, "Repositor 13").start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();
        new Thread(rep).start();

        Runnable observer = new Observer(giftCardRepository, stop);

        new Thread(observer, "Observador").start();

    }


}
