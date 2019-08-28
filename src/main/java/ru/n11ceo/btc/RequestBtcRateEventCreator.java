package ru.n11ceo.btc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.n11ceo.btc.dto.ListOfRatesDto;
import ru.n11ceo.btc.entity.UsdBtcRate;
import ru.n11ceo.btc.service.BtcRateService;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Slf4j
public class RequestBtcRateEventCreator {

    public static final String RATE_REQUEST_FREQUENCY = "*/1 * * * * *";

    private final BtcRateService service;

    @Autowired
    public RequestBtcRateEventCreator(RestTemplate restTemplate, BtcRateService service) {
        this.service = service;
    }

    @Scheduled(cron = RATE_REQUEST_FREQUENCY)
    public void requestAndSaveBtcRate() {

        Optional<UsdBtcRate> rate = service.fetchUsdRate();


        rate.ifPresent(service::saveBtcRate);
    }

}
