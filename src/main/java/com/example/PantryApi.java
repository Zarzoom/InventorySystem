package com.example;
import com.fasterxml.jackson.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import java.util.function.Supplier;
import java.util.*;

@RestController
public class PantryApi {
    
    public PantryApi(){}

    @RequestMapping(method= RequestMethod.GET, value= "/pantryName")
    public void pantryName(@RequestParam String pantryName){
        com.example.PantryCon.singleton().addPantry(pantryName);
    }
}
