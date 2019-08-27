package ru.n11ceo.btc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RequestBtcRateEventCreator {

    @Scheduled(fixedRate = 1000)
    public void requestBtcRate() {
        System.out.println("hello i'm faking btc rate");
    }


}
