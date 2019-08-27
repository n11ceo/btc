package ru.n11ceo.btc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "btc_rate")
@Data
@NoArgsConstructor
public class BtcRate {

    @Id
    @Temporal(TemporalType.DATE)
    private Date rateDate;

    @Column(name="rate")
    private Integer rate;

}
