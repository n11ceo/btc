package ru.n11ceo.btc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ListOfRatesDto {

    @JsonProperty("USD")
    private CurrencyExchangeRate USD;

    @JsonProperty("JPY")
    private CurrencyExchangeRate JPY;

    @JsonProperty("CNY")
    private CurrencyExchangeRate CNY;

    @JsonProperty("SGD")
    private CurrencyExchangeRate SGD;

    @JsonProperty("HKD")
    private CurrencyExchangeRate HKD;

    @JsonProperty("CAD")
    private CurrencyExchangeRate CAD;

    @JsonProperty("NZD")
    private CurrencyExchangeRate NZD;

    @JsonProperty("AUD")
    private CurrencyExchangeRate AUD;

    @JsonProperty("CLP")
    private CurrencyExchangeRate CLP;

    @JsonProperty("GBP")
    private CurrencyExchangeRate GBP;

    @JsonProperty("DKK")
    private CurrencyExchangeRate DKK;

    @JsonProperty("SEK")
    private CurrencyExchangeRate SEK;

    @JsonProperty("ISK")
    private CurrencyExchangeRate ISK;

    @JsonProperty("CHF")
    private CurrencyExchangeRate CHF;

    @JsonProperty("BRL")
    private CurrencyExchangeRate BRL;

    @JsonProperty("EUR")
    private CurrencyExchangeRate EUR;

    @JsonProperty("RUB")
    private CurrencyExchangeRate RUB;

    @JsonProperty("PLN")
    private CurrencyExchangeRate PLN;

    @JsonProperty("THB")
    private CurrencyExchangeRate THB;

    @JsonProperty("KRW")
    private CurrencyExchangeRate KRW;

    @JsonProperty("TWD")
    private CurrencyExchangeRate TWD;

    @Data
    @NoArgsConstructor
    @Accessors(chain = true)
    public class CurrencyExchangeRate {

        @JsonProperty(value = "15m", required = true)
        private Double delayedPrice;

        @JsonProperty(value = "last", required = true)
        private Double lastPrice;

        @JsonProperty(value = "buy", required = true)
        private Double buyPrice;

        @JsonProperty(value = "sell", required = true)
        private Double sellPrice;

        @JsonProperty(value = "symbol", required = true)
        private String currencySymbol;
    }
}

