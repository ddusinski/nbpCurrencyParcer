package com.dusinski.nbpJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonRootName("pozycja")
public class NBPrate {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("nazwa_waluty")
    private String currencyName;
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("przelicznik")
    private String multiplier;
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("kod_waluty")
    private String code;
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("kurs_kupna")
    private String buyCourse;
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("kurs_sprzedazy")
    private String sellCourse;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String no;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private LocalDate effectiveDate;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private float mid;


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

    public String getBuyCourse() {
        return buyCourse;
    }

    public void setBuyCourse(String buyCourse) {
        this.buyCourse = buyCourse;
    }

    public String getSellCourse() {
        return sellCourse;
    }

    public void setSellCourse(String sellCourse) {
        this.sellCourse = sellCourse;
    }


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public float getMid() {
        return mid;
    }

    public void setMid(float mid) {
        this.mid = mid;
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

    public String toString2() {
        return "NBPrate{" +
                "no='" + this.no + "'" +
                ", effectiveDate='" + this.effectiveDate + "'" +
                ", mid='" + this.mid + "'" +
                "}";
    }

}
