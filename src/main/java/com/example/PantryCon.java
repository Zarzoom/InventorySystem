package com.example;
import java.util.HashMap;
import java.util.function.Supplier;
import java.io.*;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PantryCon {
    HashMap<String, PantryContents> allPantrieMap= new HashMap<String, PantryContents>();
    private static PantryCon pantryConInstance;
    private static String fileName= "pantryList";

    private PantryCon(){}
    public static PantryCon singleton(){
        if(pantryConInstance==null){
            pantryConInstance=new PantryCon();
        }
        return pantryConInstance;
    }
    public void addPantry(String pantryName){
        PantryContents pantry = new PantryContents();
        allPantrieMap.put(pantryName, pantry);
        com.example.FileConverter.saveToJson(pantry, fileName);

    }
}
