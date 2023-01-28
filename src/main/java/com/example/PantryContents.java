package com.example;
import java.util.function.Supplier;
import java.io.*;
import java.io.IOException;
import java.util.*;

public class PantryContents {
    public String pantryName;
    public Item item;
    public int itemQuantity;
   

    List<Item> pantry= new ArrayList<Item>();
    public PantryContents(){
    }
    public void namePantry(){}
    public void addToPantry(Item item){
        pantry.add(item);
       
    }
    public void removeFromPantry(Item item){

    }
}
