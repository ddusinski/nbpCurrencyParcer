package com.dusinski.nbpJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPrate {

    public NBPrate(){}

    private String no;
    private LocalDate effectiveDate;
    private float mid;

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
    public String toString(){
    return "NBPrate{"+
            "no='"+this.no+"'"+
            ", effectiveDate='"+this.effectiveDate+"'"+
            ", mid="+this.mid+"'"+
            "}";
    }

}
