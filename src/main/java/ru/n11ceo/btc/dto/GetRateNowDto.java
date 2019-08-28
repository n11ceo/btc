package ru.n11ceo.btc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GetRateNowDto {
    @JsonProperty("last")
    private Double lastRate;

    @JsonProperty("delayed")
    private Double delayedRate;
}
