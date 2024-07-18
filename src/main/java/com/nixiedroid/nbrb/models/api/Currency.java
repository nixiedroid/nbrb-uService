package com.nixiedroid.nbrb.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

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
) {}