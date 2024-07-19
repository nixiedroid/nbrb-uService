package com.nixiedroid.nbrb.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

/**
 * {
 * "Cur_ID": 510,
 * "Date": "2024-07-18T00:00:00",
 * "Cur_Abbreviation": "AMD",
 * "Cur_Scale": 1000,
 * "Cur_Name": "Армянских драмов",
 * "Cur_OfficialRate": 8.2112
 * }
 */
@Builder
public record CurrencyRate(
        @JsonProperty("Cur_ID") int id,
        @JsonProperty("Date") LocalDate date,
        @JsonProperty("Cur_Abbreviation") String abbreviation,
        @JsonProperty("Cur_Scale") int scale,
        @JsonProperty("Cur_Name") String name,
        @JsonProperty("Cur_OfficialRate") double officialRate
) {
}