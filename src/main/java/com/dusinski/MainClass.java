package com.dusinski;

import java.time.LocalDate;

/**
 * nbp rate service
 */

public class MainClass {

    public static void main(String[] args)   {

//        String currency = "EUR";
//        LocalDate startDate = LocalDate.of(2013, 1, 28);
//        LocalDate endDate = LocalDate.of(2013, 1, 31);



            String currency = args[0];
            LocalDate startDate = LocalDate.parse(args[1]);
            LocalDate endDate = LocalDate.parse(args[2]);




        NBPparser nbpP = new NBPparser(currency, startDate, endDate);

    }

}
