/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0048spring2024.assign8hash;

/**
 *
 * @author juliuspruss
 */
public class AnimalNode {
    private Animal value;
    private AnimalNode next;
   
    
    public AnimalNode(Animal value){
        this.value = value;
        this.next = null;
    }
    public AnimalNode(Animal v, Animal n){
        value = v;
        this.next = null;
    }
    public Animal getValue() {
        return value;
    }

    public void setValue(Animal value) {
        this.value = value;
    }

    public AnimalNode getNext() {
        return next;
    }

    public void setNext(AnimalNode next) {
        this.next = next;
    }
    public String toString(){
        return value.toString();
    }
    
}

