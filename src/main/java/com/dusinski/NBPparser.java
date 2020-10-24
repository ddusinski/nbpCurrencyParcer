package com.dusinski;

import com.dusinski.nbpJson.NBPquote;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NBPparser {

    private static final String nbpURL = "https://www.nbp.pl/kursy/xml/";
    private static final String tableType = "c";  //foreign currencies say and buy course
    private final List<NBPquote> nbpQuoteList = new ArrayList<>();

    private LocalDate startDate = LocalDate.of(2013, 01, 28);
    private LocalDate endDate = LocalDate.of(2013, 01, 31);

    NBPparser(String currency, LocalDate start, LocalDate end) {
        this.startDate = start;
        this.endDate = end;
        loadData(start, end);

        System.out.println(this.nbpQuoteList.toString());
        System.out.println("Medium value buy course of "+currency+" : "+calcMidBuyCourse(currency));
        System.out.println("Standart deviation of Sell Course of "+currency+" : "+stanDevSellCourse(currency));
    }

    //xml file names are saved in txt file in https://www.nbp.pl/kursy/xml/
    public String findXmlName(LocalDate date) throws IOException {

        //when current date dir.txt if not dirYYYY.txt
        String fileName;
        if (date.getYear() == LocalDate.now().getYear()) {
            fileName = "dir.txt";
        } else {
            fileName = "dir" + date.getYear() + ".txt";
        }

        //downloading and converting dir.txt to String
        URLConnection con = new URL(nbpURL + fileName).openConnection();
        con.addRequestProperty("Accept", "text/plain");
        Scanner scanner = new Scanner(con.getInputStream()).useDelimiter("\\A");
        String text = scanner.hasNext() ? scanner.next() : " ";

        //searching through the file for file name. The pattern: 'xnnnzrrmmdd.xml'
        String regex = tableType + "\\d\\d\\d" + "z" + DateTimeFormatter.ofPattern("yyMMdd").format(date);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        return m.find() ? m.group(0) + ".xml" : "file name not found";

    }

    public void loadTable(LocalDate date) throws IOException {
        String url = nbpURL + findXmlName(date);
        System.out.println(url);
        URLConnection con = new URL(url).openConnection();
        con.addRequestProperty("Accept", "text/xml");
        XmlMapper xmlMapper = new XmlMapper();
        NBPquote nbpQuote = xmlMapper.readValue(con.getInputStream(), NBPquote.class);
        this.nbpQuoteList.add(nbpQuote);
    }

    private void loadData(LocalDate start, LocalDate end) {
        LocalDate date;
        for (date = start; date.isBefore(end.plusDays(1)); date = date.plusDays(1)) {
            System.out.println(date.toString());
            try {
                loadTable(date);
            } catch (Exception e) {
                System.out.println(date.toString() + ": date not found: " + e.getMessage());
            }
        }

    }

    public float calcMidBuyCourse(String currency) {
        float sum = 0;

        for (NBPquote quote : this.nbpQuoteList) {
            sum+=quote.getCurrencyBuyCourse(currency);
        }
        return sum/this.nbpQuoteList.size();
    }

    public float stanDevSellCourse(String currency) {
        float mediumValue = calcMidBuyCourse(currency);
        float quadratEquationSum=0;

        for (NBPquote quote : this.nbpQuoteList) {
            quadratEquationSum+=Math.pow(quote.getCurrencySellCourse(currency)-mediumValue,2);
        }
        return (float) Math.sqrt(quadratEquationSum/(this.nbpQuoteList.size()));
    }


}
