package com.nixiedroid.nbrb.services;

import com.nixiedroid.nbrb.models.api.Currency;
import com.nixiedroid.nbrb.models.api.CurrencyRate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class NBRbServiceTest {

    @Autowired
    NBRbService service;
    @Test
    void getCurrencyTest() {
        Currency expected = Currency.builder()
                .id(35)
                .parentId(35)
                .code("196")
                .abbreviation("CYP")
                .name("Кипрский фунт")
                .nameBel("Кіпрскі фунт")
                .nameEng("Cyprus Pound")
                .quotName("1 кипрский фунт")
                .quotNameBel("1 кіпрскі фунт")
                .quotNameEng("1 Cyprus Pound")
                .nameMulti("кипрский фунт")
                .nameBelMulti("кіпрскі фунт")
                .nameEngMulti("Cyprus Pound")
                .scale(1)
                .periodicity(1)
                .dateEnd(LocalDate.of(2010,7,31))
                .dateStart(LocalDate.of(1991,1,1))
                .build();
        Currency c = service.getCurrencyById(35);

        Assertions.assertEquals(expected,c);
    }

    @Test
    void getRateTest() {
        CurrencyRate expected = CurrencyRate.builder()
                .id(431)
                .date(LocalDate.now())
                .abbreviation("USD")
                .name("Доллар США")
                .scale(1)
                .officialRate(0.0)
                .build();
        CurrencyRate currencyRate = service.getRateByIdToday(431);

        Assertions.assertEquals(expected.id(),currencyRate.id());
        Assertions.assertEquals(expected.date(),currencyRate.date());
        Assertions.assertEquals(expected.name(),currencyRate.name());
        Assertions.assertEquals(expected.scale(),currencyRate.scale());

        CurrencyRate currencyRate2 = service.getRateByNameToday("USD");

        Assertions.assertEquals(currencyRate,currencyRate2);

    }
}