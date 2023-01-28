package com.example;

public class ShoppingListCon {
    private static ShoppingListCon shoppingListConInstance;

    private ShoppingListCon(){}
    public static ShoppingListCon singleton(){
        if(shoppingListConInstance==null){
            shoppingListConInstance= new ShoppingListCon();
        }
        return shoppingListConInstance;
    }
}
