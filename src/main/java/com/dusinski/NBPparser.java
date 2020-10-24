package com.dusinski;

import com.dusinski.nbpJson.NBPquote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NBPparser {

    private static String nbpURI="https://www.nbp.pl/kursy/xml/c073z070413.xml";

    private final List<NBPquote> nbpQuoteList;
    private String currecyCode;
    private LocalDate startDate;
    private LocalDate endDate;

    public NBPparser() {
        this.nbpQuoteList = new ArrayList<>();
    }


}
