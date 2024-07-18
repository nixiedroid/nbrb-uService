package com.nixiedroid.nbrb.services;

import com.nixiedroid.nbrb.models.api.Currency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NBRbServiceTest {

    @Autowired
    NBRbService service;

    @Test
    void getBookById() {
        Currency c;
        c = service.getCurrencyById(35);
        System.out.println(c);
    }
}