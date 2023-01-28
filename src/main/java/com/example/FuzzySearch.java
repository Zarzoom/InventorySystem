package com.example;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class FuzzySearch {
    private static FuzzySearch fuzzySearchInstance;

    private FuzzySearch(){}

    public static FuzzySearch singleton(){
        if (fuzzySearchInstance==null){
            fuzzySearchInstance= new FuzzySearch();
        }
        return fuzzySearchInstance;
    }

    public List<Item> containsSearch(String searchVal) {
        return com.example.ItemCon.singleton()
                .getList()
                .stream()
                .filter(item -> StringUtils.containsIgnoreCase(item.genericName, searchVal)
                        || StringUtils.containsIgnoreCase(item.brand, searchVal))
                .collect(Collectors.toList());
    }
}
