package ru.n11ceo.btc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class BtcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BtcApplication.class, args);
    }

}
