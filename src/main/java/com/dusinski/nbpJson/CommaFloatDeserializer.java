package com.dusinski.nbpJson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CommaFloatDeserializer extends JsonDeserializer<Float> {

    @Override
    public Float deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String floatString = jsonParser.getText();
        if (floatString.contains(",")){
            floatString=floatString.replace(",",".");
        }
        return Float.valueOf(floatString);
    }
}
