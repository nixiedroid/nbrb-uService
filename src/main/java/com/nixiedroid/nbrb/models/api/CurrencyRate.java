package com.nixiedroid.nbrb.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CurrencyRate(
        @JsonProperty("Cur_ID") int id,
        @JsonProperty("Date") LocalDate date,
        @JsonProperty("Cur_Abbreviation") String abbreviation,
        @JsonProperty("Cur_Scale") int scale,
        @JsonProperty("Cur_Name") String name,
        @JsonProperty("Cur_OfficialRate") double officialRate
) {}