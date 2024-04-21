/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0045fall2023.assign10;

/**
 *
 * @author juliuspruss
 */

public class TestStoreSaleItemList {
    public static void main(String[] args){
        // the items created from store item to make the items in new sale and their id 

        StoreItem item = new StoreItem("Dinner Table", 18453 );
        StoreItem item2 = new StoreItem("Bay Window", 16534);
        StoreItem item3 = new StoreItem("Stool",26123 );
        StoreItem item4 = new StoreItem("Lamp",21000 );
        StoreItem item5 = new StoreItem ("Couch",17564 );
        StoreItem item6 = new StoreItem("Footstool",28162 );
        StoreItem item7 = new StoreItem("Large Rug", 19653);
        
        //the items created for store sale item that go into new sale
        
        StoreSaleItem dinnerTable = new StoreSaleItem(item, 349.99, 10);
        StoreSaleItem bayWindow = new StoreSaleItem(item2, 2345.00, 5);
        StoreSaleItem stool = new StoreSaleItem(item3, 139.95, 12);
        StoreSaleItem lamp = new StoreSaleItem(item4, 39.99, 15);
        StoreSaleItem couch = new StoreSaleItem(item5, 999.49, 3);
        StoreSaleItem footstool = new StoreSaleItem(item6, 79.99, 13);
        StoreSaleItem largeRug = new StoreSaleItem(item7,199.99, 4 );
        AList<StoreSaleItem> newSale = new AList(25);
        
        //add items in the list called new sale from position 1 to 5
        
        newSale.add(1, dinnerTable);
        newSale.add(2, bayWindow);
        newSale.add(3, stool);
        newSale.add(4, lamp);
        newSale.add(5, couch);
        
        //replace the second item at position 2 and create and put a new item called footstool
        
        newSale.add(2, footstool);
        
        // remove the item at position 3
        
        newSale.remove(3);
        
        //replace the first item in the list at position 1 and put the new item large rug 
        
        newSale.replace(1, dinnerTable);
        newSale.add(1, largeRug);
        //swap the first item and the second item with their positions from 1 to 5 and 5 to 1
        
        newSale.replace(1, couch);
        newSale.replace(5, largeRug);
        
        //Switch the id number from 21000 to 11233
        
        StoreSaleItem newLamp = newSale.getEntry(4);
        StoreItem temp = newLamp.getStoreItem();
        temp.setId(11233);
        newLamp.setStoreItem(temp);
        newSale.replace(4, newLamp);
        
        //changed the price for the fifth item to 209.99
        StoreSaleItem newPrice = newSale.getEntry(5);
        newPrice.setPrice(209.99);
        newSale.replace(5, newPrice);
        
        
        for(int i = 1; i < newSale.getLength(); i ++){
            StoreSaleItem temp3 = newSale.getEntry(i);
            System.out.println(temp3.toString() + " ");
        }    
            
        
    }
}
