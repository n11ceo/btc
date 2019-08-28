package ru.n11ceo.btc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.n11ceo.btc.dto.FindRateByDateDto;
import ru.n11ceo.btc.dto.GetRateNowDto;
import ru.n11ceo.btc.dto.ListOfRatesDto;
import ru.n11ceo.btc.entity.UsdBtcRate;
import ru.n11ceo.btc.repository.BtcRateRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class BtcRateServiceImpl implements BtcRateService {

    private final BtcRateRepository repository;

    private final RestTemplate restTemplate;

    public static final String EXCHANGE_RATES_API = "https://blockchain.info/ticker";

    @Autowired
    public BtcRateServiceImpl(BtcRateRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void saveBtcRate(UsdBtcRate entity) {
        log.debug("Saving USD-to-BTC rate into the database: " + entity.toString());
        repository.save(entity);
    }

    @Override
    public Optional<GetRateNowDto> getRateNow() {
        var usdBtcRate = fetchUsdRate();
        usdBtcRate.ifPresent(this::saveBtcRate);

        return usdBtcRate.map(rate ->
                new GetRateNowDto()
                        .setLastRate(rate.getLastRate())
                        .setDelayedRate(rate.getDelayedRate())
        );
    }

    @Override
    public Optional<FindRateByDateDto> findRateByDate(LocalDate date) {
        return Optional.of(new FindRateByDateDto()
                .setBtcUsdRates(repository.findAllByRateDateAfterAndRateDateBefore(date.atStartOfDay(), date.plusDays(1).atStartOfDay())));
    }

    @Override
    public Optional<UsdBtcRate> fetchUsdRate() {
        return Optional
                .ofNullable(restTemplate.getForObject(EXCHANGE_RATES_API, ListOfRatesDto.class))
                .map(rates -> {
                    log.debug("Received BTC rates: " + rates.toString());
                    return new UsdBtcRate()
                            .setRateDate(LocalDateTime.now())
                            .setDelayedRate(rates.getUSD().getDelayedPrice())
                            .setLastRate(rates.getUSD().getLastPrice());
                });
    }
}
