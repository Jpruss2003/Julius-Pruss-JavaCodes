/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0048spring2024.assign8hash;

/**
 *
 * @author juliuspruss
 */
public class Animal {
    private int ID;
    private String animalName;
    private String kingdom;
    private String phylum;
    private String subphylum;
    private String animalClass;
    private String animalOrder;
    private String family;
    private String genus;
    

public Animal(int ID, String animalName, String kingdom, String phylum, String subphylum, String animalClass, String animalOrder, String family, String genus){
    this.ID = ID;
    this.animalName = animalName;
    this.kingdom = kingdom;
    this.phylum = phylum;
    this.subphylum = subphylum;
    this.animalClass = animalClass;
    this.animalOrder = animalOrder;
    this.family = family;
    this.genus = genus;
}
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String a) {
        this.animalName = a;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String k) {
        this.kingdom = k;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String p) {
        this.phylum = p;
    }

    public String getSubphylum() {
        return subphylum;
    }

    public void setSubphylum(String s) {
        this.subphylum = s;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(String Ac) {
        this.animalClass = Ac;
    }

    public String getAnimalOrder() {
        return animalOrder;
    }

    public void setAnimalOrder(String Ao) {
        this.animalOrder = Ao;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String f) {
        this.family = f;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String g) {
        this.genus = g;
    }
    
    public String toString(){
        return "ID: " + ID + "\n" +
           "Animal Name: " + animalName + "\n" +
           "Kingdom: " + kingdom + "\n" +
           "Phylum: " + phylum + "\n" +
           "Subphylum: " + subphylum + "\n" +
           "Animal Class: " + animalClass + "\n" +
           "Animal Order: " + animalOrder + "\n" +
           "Family: " + family + "\n" +
           "Genus: " + genus;
    }
}