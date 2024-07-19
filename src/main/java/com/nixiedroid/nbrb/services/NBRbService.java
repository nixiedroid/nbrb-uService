package com.nixiedroid.nbrb.services;

import com.nixiedroid.nbrb.models.api.Currency;
import com.nixiedroid.nbrb.models.api.CurrencyRate;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;


@Service
public class NBRbService {

    static final String RATE_API_URL = "https://api.nbrb.by/exrates/rates";
    static final String CURRENCY_API_URL = "https://api.nbrb.by/exrates/currencies";

    public Currency getCurrencyById(int id) {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        URI uri = UriComponentsBuilder.fromHttpUrl(CURRENCY_API_URL).pathSegment(String.valueOf(id)).build().toUri();
        return restTemplate.getForObject(uri, Currency.class);
    }

    public CurrencyRate getRateByIdToday(int id) {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        URI uri = UriComponentsBuilder.fromHttpUrl(RATE_API_URL)
                .pathSegment(String.valueOf(id))
                .queryParam("periodicity", 0)
                .queryParam("parammode", 0)
                .queryParam("ondate", LocalDate.now())
                .build().toUri();
        return restTemplate.getForObject(uri, CurrencyRate.class);
    }

    public CurrencyRate getRateByNameToday(String name) {//name is ISO4217 encoded
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        URI uri = UriComponentsBuilder.fromHttpUrl(RATE_API_URL)
                .pathSegment(name)
                .queryParam("periodicity", 0)
                .queryParam("parammode", 2)
                .queryParam("ondate", LocalDate.now())
                .build().toUri();
        return restTemplate.getForObject(uri, CurrencyRate.class);
    }


    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int TIMEOUT_500_MS = 500;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(TIMEOUT_500_MS);
        return clientHttpRequestFactory;
    }
}
