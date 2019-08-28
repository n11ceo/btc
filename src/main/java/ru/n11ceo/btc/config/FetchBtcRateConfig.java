package ru.n11ceo.btc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import ru.n11ceo.btc.exception.RestTemplateResponseErrorHandler;


@Configuration
@EnableScheduling
public class FetchBtcRateConfig {

    @Bean
    @Autowired
    public RestTemplate getRestTemplateBean(RestTemplateBuilder restTemplateBuilder,
                                            RestTemplateResponseErrorHandler responseErrorHandler) {
        return restTemplateBuilder
                .errorHandler(responseErrorHandler)
                .build();
    }

}
