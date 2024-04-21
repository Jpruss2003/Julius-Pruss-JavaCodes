/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0045fall2023.assign10;

/**
 *
 * @author juliuspruss
 */
public class StoreItem {
    private String name;
    private int Id;

    public StoreItem(){
        name = "";
        Id = 0;
}
    public StoreItem(String n, int i){
        name = n;
        Id = i;
}
    public void setName(String n){
        name = n;
    }
    public void setId(int i){
        Id = i;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return Id;
    }
    public String toString(){
        return(" Name: " + name + " ID: "+ Id);
    }
}
  

