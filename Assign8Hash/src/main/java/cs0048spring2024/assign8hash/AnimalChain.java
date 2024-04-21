/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0048spring2024.assign8hash;

/**
 *
 * @author juliuspruss
 */
public class AnimalChain {
    private AnimalNode firstNode;
    private int numberOfNodes;
   
    
    
    public int getNumberOfNodes(){
        return numberOfNodes;
    }
    public void setNumberOfNodes(int numberOfNodes){
        this.numberOfNodes = numberOfNodes;
    }
    

    // Method to add a new AnimalNode to the chain
    public void add(Animal newEntry) {
    if (isEmpty()) {
        firstNode = new AnimalNode(newEntry, null);
    } else {
        AnimalNode currentNode = firstNode;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(new AnimalNode(newEntry, null));
    }
    numberOfNodes++;
}

    public boolean isEmpty(){
        return firstNode == null;
    }
    
    public String toString(){
        String result = firstNode.getValue().toString();
        AnimalNode currNode = firstNode;
        while(currNode.getNext() != null){
            result = result + " " + currNode.getNext();
            currNode = currNode.getNext();
        }
        return result;
    }
    
}