package ru.n11ceo.btc.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.n11ceo.btc.entity.UsdBtcRate;

import java.util.List;

@Data
@Accessors(chain = true)
public class FindRateByDateDto {
    private List<UsdBtcRate> btcUsdRates;
}
