package com.dusinski.nbpJson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.security.Key;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("tabela_kursow")
public class NBPquote {

    @JsonProperty("numer_tabeli")
    private String table;
    @JsonProperty("data_notowania")
    private String noteDate;
    @JsonProperty("data_publikacji")
    private String publicationDate;

    @JsonProperty("pozycja")
    @JacksonXmlElementWrapper(useWrapping = false)
    private final Map<String, NBPrate> rates = new HashMap<>();

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Map<String, NBPrate> getRates() {
        return this.rates;
    }

    public void setRates(NBPrate rates) {
        this.rates.put(rates.getCode(), rates);
    }

    public Float getCurrencyBuyCourse(String currencyKey){
        return this.rates.get(currencyKey).getBuyCourse();
    }
    public Float getCurrencySellCourse(String currencyKey){
        return this.rates.get(currencyKey).getSellCourse();
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
                ",rates=" + rates.toString() +
                "}";
    }
}
