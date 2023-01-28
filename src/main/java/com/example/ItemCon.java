package com.example;

import java.util.function.Supplier;
import java.io.*;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ItemCon {
    private static ItemCon itemManagerInstance;
    private static String fileName= "itemListFile.json";
    List<Item> itemList = new ArrayList<Item>();

    private ItemCon() {
        itemList=com.example.FileConverter.itemFromJson(new TypeReference<List<Item>>(){}, fileName);
        
        int five= 5;
    }

    public static ItemCon singleton() {
        if (itemManagerInstance == null) {
            itemManagerInstance = new ItemCon();
        }
        return itemManagerInstance;
    }

    public void addToList(Item postmanItem) {
        itemList.add(postmanItem);
        com.example.FileConverter.saveToJson(itemList, fileName);;
    }

    public List<Item> getList(){
        return itemList;
    }

    /*public void saveList() {
        ObjectMapper mapItemList = new ObjectMapper();
        mapItemList.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String itemListToJson = mapItemList.writeValueAsString(itemList);
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(itemListToJson);
            printWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void itemFromJson(){
        ObjectMapper jsonToItemMapper= new ObjectMapper();
        try{
            Item[] jsonFileToItem= jsonToItemMapper.readValue(new File(fileName), Item[].class);
            itemList= Arrays.asList(jsonFileToItem);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        } */
    }
