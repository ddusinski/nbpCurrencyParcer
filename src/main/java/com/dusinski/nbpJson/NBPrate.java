package com.dusinski.nbpJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPrate {

    @JsonProperty("nazwa_waluty")
    private String currencyName;
    @JsonProperty("przelicznik")
    private String multiplier;
    @JsonProperty("kod_waluty")
    private String code;
    @JsonProperty("kurs_kupna")
    @JsonDeserialize(using = CommaFloatDeserializer.class)
    private float buyCourse;
    @JsonDeserialize(using = CommaFloatDeserializer.class)
    @JsonProperty("kurs_sprzedazy")
    private float sellCourse;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currency) {
        this.currencyName = currency;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getBuyCourse() {
        return buyCourse;
    }

    public void setBuyCourse(float buyCourse) {
        this.buyCourse = buyCourse;
    }

    public float getSellCourse() {
        return sellCourse;
    }

    public void setSellCourse(float sellCourse) {
        this.sellCourse = sellCourse;
    }

    @Override
    public String toString() {
        return "NBPrate{" +
                "currencyName='" + this.currencyName + "'" +
                ", multiplier='" + this.multiplier + "'" +
                ", code='" + this.code + "'" +
                ", buyCourse='" + this.buyCourse + "'" +
                ", sellCourse='" + this.sellCourse + "'" +
                "}";
    }
}
