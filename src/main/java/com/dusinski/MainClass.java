package com.dusinski;

import com.dusinski.nbpJson.NBPquote;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * nbp rate service
 */

public class MainClass {

    public static void main(String[] args) throws IOException {

        String url="https://www.nbp.pl/kursy/xml/c073z070413.xml";

        URLConnection con = new URL(url).openConnection();
        con.addRequestProperty("Accept","text/xml");

        XmlMapper xmlMapper = new XmlMapper();
        NBPquote nbpQuote = xmlMapper.readValue(con.getInputStream(), NBPquote.class);
        System.out.println(nbpQuote.toString());

    }




}
