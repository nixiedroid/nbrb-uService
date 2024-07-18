package com.nixiedroid.nbrb.services;

import com.nixiedroid.nbrb.models.api.Currency;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Currencies
 * {
 * "Cur_ID": 35,
 * "Cur_ParentID": 35,
 * "Cur_Code": "196",
 * "Cur_Abbreviation": "CYP",
 * "Cur_Name": "Кипрский фунт",
 * "Cur_Name_Bel": "Кіпрскі фунт",
 * "Cur_Name_Eng": "Cyprus Pound",
 * "Cur_QuotName": "1 кипрский фунт",
 * "Cur_QuotName_Bel": "1 кіпрскі фунт",
 * "Cur_QuotName_Eng": "1 Cyprus Pound",
 * "Cur_NameMulti": "кипрский фунт",
 * "Cur_Name_BelMulti": "кіпрскі фунт",
 * "Cur_Name_EngMulti": "Cyprus Pound",
 * "Cur_Scale": 1,
 * "Cur_Periodicity": 1,
 * "Cur_DateStart": "1991-01-01T00:00:00",
 * "Cur_DateEnd": "2010-07-31T00:00:00"
 * },
 * {
 * "Cur_ID": 36,
 * "Cur_ParentID": 36,
 * "Cur_Code": "208",
 * "Cur_Abbreviation": "DKK",
 * "Cur_Name": "Датская крона",
 * "Cur_Name_Bel": "Дацкая крона",
 * "Cur_Name_Eng": "Danish Krone",
 * "Cur_QuotName": "1 Датская крона",
 * "Cur_QuotName_Bel": "1 Дацкая крона",
 * "Cur_QuotName_Eng": "1 Danish Krone",
 * "Cur_NameMulti": "",
 * "Cur_Name_BelMulti": "",
 * "Cur_Name_EngMulti": "",
 * "Cur_Scale": 1,
 * "Cur_Periodicity": 0,
 * "Cur_DateStart": "1991-01-01T00:00:00",
 * "Cur_DateEnd": "2016-06-30T00:00:00"
 * },
 */

/**
 * Rates
 * {
 *         "Cur_ID": 440,
 *         "Date": "2024-07-18T00:00:00",
 *         "Cur_Abbreviation": "AUD",
 *         "Cur_Scale": 1,
 *         "Cur_Name": "Австралийский доллар",
 *         "Cur_OfficialRate": 2.1510
 *     },
 *     {
 *         "Cur_ID": 510,
 *         "Date": "2024-07-18T00:00:00",
 *         "Cur_Abbreviation": "AMD",
 *         "Cur_Scale": 1000,
 *         "Cur_Name": "Армянских драмов",
 *         "Cur_OfficialRate": 8.2112
 *     },
 */


@Service
public class NBRbService {

    static final String API_URL = "https://api.nbrb.by/exrates/currencies";

    public Currency getCurrencyById(int id) {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        String url = API_URL + "/" + id;
        return restTemplate.getForObject(url, Currency.class);
    }


    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int TIMEOUT_500_MS = 500;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(TIMEOUT_500_MS);
        return clientHttpRequestFactory;
    }
}
