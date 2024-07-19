package com.nixiedroid.nbrb.controllers;

import com.nixiedroid.nbrb.models.dto.CurrencyDTO;
import com.nixiedroid.nbrb.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    private final CurrencyService service;

    @Autowired
    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    /**
     * Listens for GET requests at <a href="/api/currencies">/api/currencies</a>
     *
     * @return json list of {@link CurrencyDTO}
     */
    @GetMapping
    public List<CurrencyDTO> getAll() {
        service.getCurrency();
        return null;
    }

    /**
     * Listens for GET requests at <a href="/api/currencies/{id}">/api/currencies/{id}</a>
     *
     * @return json object {@link CurrencyDTO} if {id} exists or null
     */
    @GetMapping("/{id}")
    public ResponseEntity<CurrencyDTO> getById(@PathVariable Long id) {
        return null;
    }

}
