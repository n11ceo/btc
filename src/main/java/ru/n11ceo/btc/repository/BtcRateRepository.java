package ru.n11ceo.btc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.n11ceo.btc.entity.UsdBtcRate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface BtcRateRepository extends JpaRepository<UsdBtcRate, Date> {

    List<UsdBtcRate> findAllByRateDateAfterAndRateDateBefore(LocalDateTime startDateTime, LocalDateTime endDateTime);

}
