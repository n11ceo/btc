package ru.n11ceo.btc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class CurrencyExchangeRateDto {
    public static final String USD_RATE_CODE = "USD";

    @JsonProperty("15m")
    private final double delayedPrice;

    @JsonProperty("last")
    private final double lastPrice;

    @JsonProperty("buy")
    private final double buyPrice;

    @JsonProperty("sell")
    private final double sellPrice;

    @JsonProperty("symbol")
    private final char currencySymbol;
}
