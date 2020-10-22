package com.dusinski;

import com.dusinski.nbpJson.NBPquote;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpHeaders;
import java.util.Arrays;

/**
 * nbp rate service
 */
@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);


    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
//            NBPquote nbpQuote = restTemplate.getForObject(
//                    "http://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-01/2012-01-31/?format=json"
//                    , NBPquote.class);



            ResponseEntity<String> entity = restTemplate.getForEntity("https://www.nbp.pl/kursy/xml/c073z070413.xml", String.class);


            log.info(entity.getBody());

            ObjectMapper objectMapper = new ObjectMapper();

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
            xmlMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);

            NBPquote nbpQuote = xmlMapper.readValue(entity.getBody(), NBPquote.class);

//            NBPquote nbpQuote = restTemplate.getForEntity(
//                    "https://www.nbp.pl/kursy/xml/c073z070413.xml"
//
//                    , NBPquote.class);
            log.info(nbpQuote.toString());


//            log.info("calculated medium value of rates: "+nbpQuote.calcMediumValue());
        };
    }

}
