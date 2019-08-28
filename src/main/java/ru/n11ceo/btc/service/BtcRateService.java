package ru.n11ceo.btc.service;

import ru.n11ceo.btc.dto.FindRateByDateDto;
import ru.n11ceo.btc.dto.GetRateNowDto;
import ru.n11ceo.btc.entity.UsdBtcRate;

import java.time.LocalDate;
import java.util.Optional;

public interface BtcRateService {

    void saveBtcRate(UsdBtcRate entity);

    Optional<GetRateNowDto> getRateNow();

    Optional<FindRateByDateDto> findRateByDate(LocalDate date);

    Optional<UsdBtcRate> fetchUsdRate();

}
