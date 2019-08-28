package ru.n11ceo.btc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.n11ceo.btc.dto.FindRateByDateDto;
import ru.n11ceo.btc.dto.GetRateNowDto;
import ru.n11ceo.btc.service.BtcRateService;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@Slf4j
public class BtcRateController {

    final private BtcRateService service;

    @Autowired
    public BtcRateController(BtcRateService service) {
        this.service = service;
    }

    @GetMapping("/rate/now")
    public Optional<GetRateNowDto> getRateNow() {
        return service.getRateNow();
    }

    @GetMapping("/rate")
    public Optional<FindRateByDateDto> findRateByDateTime(@RequestParam(value = "date", required = true) LocalDate date) {
        return service.findRateByDate(date);
    }

}
