package com.example;

import java.util.function.Supplier;
import java.io.*;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class FileConverter<T> {



    public static <T> void saveToJson(T objectForSerialization, String fileName) {
        ObjectMapper mapItemList = new ObjectMapper();
        mapItemList.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String objectToJson = mapItemList.writeValueAsString(objectForSerialization);
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(objectToJson);
            printWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public static <T> T itemFromJson(TypeReference<T> type, String fileName) {
        ObjectMapper jsonToObjectMapper = new ObjectMapper();
        T ifNothinElse= null;
        try {
            ifNothinElse= jsonToObjectMapper.readValue(new File(fileName), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ifNothinElse;
    }
}
