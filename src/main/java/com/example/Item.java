package com.example;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import org.h2.server.web.JakartaWebServlet;
import jakarta.persistence.*;;

@Entity
public class Item{
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long itemID;
  public String brand;
  public String price;
  public String genericName;
  public String size;
public Item(){}
public Item(String brand, String price, String genericName, String size){
  this.brand=brand;
  this.price=price;
  this.genericName=genericName;
  this.size=size;
}
}
