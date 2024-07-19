package com.nixiedroid.nbrb.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CurrencyDTO(
        @JsonProperty("Cur_ID") int id,
        @JsonProperty("Date") LocalDate date,
        @JsonProperty("Cur_Abbreviation") String abbreviation,
        @JsonProperty("Cur_OfficialRate") double officialRate
) {
}
