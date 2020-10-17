package com.dusinski.nbpJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPquote {

    private String table;
    private String currency;
    private String code;
    private List<NBPrate> rates;


    public NBPquote() {
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<NBPrate> getRates() {
        return this.rates;
    }

    public void setRates(List<NBPrate> rates) {
        this.rates = rates;
    }

    public double calcMediumValue() {
        float sum=0;
        for (NBPrate rate : this.rates) {
            sum +=rate.getMid();
        }
        return sum/this.rates.size();
    }

    @Override
    public String toString() {
        return "NBPquote{" +
                "table='" + this.table + "'" +
                ",currency='" + this.currency + "'" +
                ",code='" + this.code + "'" +
                ",rates=" + rates +
                "}";
    }


}
