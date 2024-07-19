package com.nixiedroid.nbrb.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

/**
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
 * }
 */
@Builder
public record Currency(
        @JsonProperty("Cur_ID") int id,
        @JsonProperty("Cur_ParentID") int parentId,
        @JsonProperty("Cur_Code") String code,
        @JsonProperty("Cur_Abbreviation") String abbreviation,
        @JsonProperty("Cur_Name") String name,
        @JsonProperty("Cur_Name_Bel") String nameBel,
        @JsonProperty("Cur_Name_Eng") String nameEng,
        @JsonProperty("Cur_QuotName") String quotName,
        @JsonProperty("Cur_QuotName_Bel") String quotNameBel,
        @JsonProperty("Cur_QuotName_Eng") String quotNameEng,
        @JsonProperty("Cur_NameMulti") String nameMulti,
        @JsonProperty("Cur_Name_BelMulti") String nameBelMulti,
        @JsonProperty("Cur_Name_EngMulti") String nameEngMulti,
        @JsonProperty("Cur_Scale") int scale,
        @JsonProperty("Cur_Periodicity") int periodicity,
        @JsonProperty("Cur_DateStart") LocalDate dateStart,
        @JsonProperty("Cur_DateEnd") LocalDate dateEnd
) {
}