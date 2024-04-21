/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0045fall2023.assign10;

/**
 *
 * @author juliuspruss
 */
public class StoreSaleItem {
    private StoreItem item;
    private double price;
    private int quantity;
    
public StoreSaleItem(){
    item = new StoreItem();
    price = 0.0;
    quantity = 0;
    }

public StoreSaleItem(StoreItem n, double p, int q){
    price = p;
    quantity = q;
    item = n;
}
public StoreItem getStoreItem(){
    return item;
}
public double getPrice(){
    return price;
}
public int getQuantity(){
    return quantity;
}
public void setStoreItem(StoreItem n){
    item = n;
}
public void setPrice(double p){
    price = p;
}
public void setQuantity(int q){
    quantity = q;
}
public String toString(){
    return("Store item =" + item + " Price = " + price + " Quantity = " + quantity);
}
}
