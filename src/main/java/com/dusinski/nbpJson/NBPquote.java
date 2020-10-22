package com.dusinski.nbpJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("tabela_kursow")
public class NBPquote {

    @JsonProperty("numer_tabeli")
    private String table;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String currency;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String code;
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("data_notowania")
    private String noteDate;
    @JsonProperty("data_publikacji")
    private String publicationDate;
//    @JsonProperty("pozycja")
    @JacksonXmlElementWrapper
    private List<NBPrate> rates;



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


    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }


    @Override
    public String toString() {
        return "NBPquote{" +
                "table='" + this.table + "'" +
                ",noteDate='" + this.noteDate + "'" +
                ",publicationDate='" + this.publicationDate + "'" +
                ",rates=" + rates +
                "}";
    }
    public String toString2() {
        return "NBPquote{" +
                "table='" + this.table + "'" +
                ",currency='" + this.currency + "'" +
                ",code='" + this.code + "'" +
                ",rates=" + rates +
                "}";
    }

}
