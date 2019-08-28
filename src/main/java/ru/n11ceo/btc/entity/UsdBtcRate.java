package ru.n11ceo.btc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "btc_rate")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UsdBtcRate {

    @Id
    private LocalDateTime rateDate;

    @Column(name="delayed")
    private Double delayedRate;

    @Column(name="last")
    private Double lastRate;

}
