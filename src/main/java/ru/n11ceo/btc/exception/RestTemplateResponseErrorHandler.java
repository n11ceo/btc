package ru.n11ceo.btc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Slf4j
@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == CLIENT_ERROR
                        || response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode()
                .series() == SERVER_ERROR) {
            log.info("There was a server-side error while fetching data");
        } else if (response.getStatusCode()
                .series() == CLIENT_ERROR) {
            log.info("There was a client-side error while fetching data");
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                log.info("Requested resource was not found!");
            }
        }
    }
}
