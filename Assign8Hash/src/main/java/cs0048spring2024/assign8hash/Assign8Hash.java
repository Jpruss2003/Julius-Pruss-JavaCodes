/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cs0048spring2024.assign8hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Julius Pruss
 */
public class Assign8Hash {
    public static void main(String[] args) {
        Animal[] frequency = new Animal[1349];
        AnimalChain[] Animal = new AnimalChain[887];
        Assign8Hash hashing = new Assign8Hash();
        try {
            Scanner fileInput = new Scanner(new File("animals.csv"));
            fileReader(fileInput,frequency);
            int[][] freqTable = new int[10][14];
            hashing.tableCreation(frequency,Animal,freqTable);
            
            
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
        System.out.println("Part 2 of the program, printing the after results");
        
        String redBelliedBlackSnake = "Red-Bellied Black Snake";
        int hashCode = generateHashCode(redBelliedBlackSnake);
        int index = getHashIndex(hashCode);
        
        System.out.println("Hash Code for Red-Bellied Black Snake: " + hashCode);
        System.out.println("Index for Red-Bellied Black Snake: " + index);

        printIndexContents(Animal, 851);

        // 3. Print all the indexes where the chain length is 5
        printIndexesWithChainLength(Animal, 5);
        
        //this method for getting the value of the brown rat and marsh deer are not correct, it will not print the value out 
        printAnimalIndex(Animal, "Brown Rat");
        printAnimalIndex(Animal, "Marsh Deer");
        //this record is wrong as well as it will not print the values after you delete it 
        System.out.println("Indexes and AnimalList after deleting records:");
        deleteRecord(Animal, "Sunda Flying Lemur");
        deleteRecord(Animal, "Lesser Flamingo");
    }
    public static void fileReader(Scanner fileInput,Animal[] table){
        try (fileInput) {
            int numberOfNodes=0;
            // Set the delimiter to a comma
            fileInput.useDelimiter(",|\\R");
            while (fileInput.hasNext()) {
                //this are the attributes that are in the file that the scanner will read
                int ID = fileInput.nextInt();
                String animalName = fileInput.next();
                String kingdom = fileInput.next();
                String phylum = fileInput.next();
                String subphylum = fileInput.next();
                String animalClass = fileInput.next();
                String animalOrder = fileInput.next();
                String family = fileInput.next();
                String genus = fileInput.next();
                
                
                Animal newAnimal = new Animal(ID,animalName,kingdom,phylum,subphylum,animalClass,animalOrder,family,genus);
                table[numberOfNodes]= newAnimal; // this will take the number of nodes to the table adn add them to the new animal
                numberOfNodes++; //this will put the entries into the right columns and rows and will go until max table has 
            }
            //to close the scanner so that it would over read datat
        }
        
        }
    //this method will convert the animal to key and make a hash code for each animal
    public static int generateHashCode(String animalName) {
        int hashCode = 0;
        for (int i = 0; i < animalName.length(); i++) {
            char c = animalName.charAt(i);
            hashCode += (i + 1) * (int) c;
    }
    return hashCode;
    }
    //this code will get the has code by the size of the 2d array
    public static int getHashIndex(int hashCode){  
        return hashCode % 887;
    }
    
    public void animalInsertions(Animal[] animal, AnimalChain[] animalTable, int frontNode, int lastNode) {
        for (int i = frontNode; i < lastNode; i++) { // Loop through the specified range of animals
        // Generate hash index for the current animal
            int hashIndex = getHashIndex(generateHashCode(animal[i].getAnimalName()));
        
        // Add the current animal to the chain at the calculated index
            if (animalTable[hashIndex] == null) {
                animalTable[hashIndex] = new AnimalChain();
        }
            animalTable[hashIndex].add(animal[i]);
    }
    }
    public void tableCreation(Animal[] animal, AnimalChain[] animalTable, int[][] frequencyAnimalTable) {
    // Define the start and end intervals for insertion
    int[][] intervals = {
        {0, 100}, {101, 200}, {201, 300}, {301, 400}, {401, 500},
        {501, 600}, {601, 700}, {701, 800}, {801, 900}, {901, 1000},
        {1001, 1100}, {1101, 1200}, {1201, 1300}, {1301, 1349}
    };

    // Iterate through each interval and perform insertions and frequency analysis
    for (int i = 0; i < intervals.length; i++) {
        int frontNode = intervals[i][0];
        int lastNode = intervals[i][1];
        animalInsertions(animal, animalTable, frontNode, lastNode);
        frequencyAnalysis(animalTable, frequencyAnimalTable, i);
    }

    // Print the frequency table
    printFrequencyTable(frequencyAnimalTable);
}

private void printFrequencyTable(int[][] frequencyAnimalTable) {
    // Headers for the rows and columns
    String[] rowHeaders = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] colHeaders = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100", "1200", "1300", "1349"};

    // Print the column headers
    System.out.print("     ");
    for (String header : colHeaders) {
        System.out.printf("%5s ", header);
    }
    System.out.println("\n------------------------------------------------------------------------------------------");
    System.out.println("------------------------------------------------------------------------------------------");
    // Print each row of the frequency table
    for (int i = 0; i < frequencyAnimalTable.length; i++) {
        System.out.print(rowHeaders[i] + " | ");
        for (int j = 0; j < frequencyAnimalTable[i].length; j++) {
            System.out.printf("%5d ", frequencyAnimalTable[i][j]);
        }
        System.out.println();
    }
}
    public void frequencyAnalysis(AnimalChain[] animalTable, int[][] frequencyAnimalTable, int column) {
    // Iterate through each slot in the hash table
        for (AnimalChain chain : animalTable) {
        // Determine the length of the chain; it's 0 if the chain is null
            int length = (chain == null) ? 0 : chain.getNumberOfNodes();

        // Increment the frequency count for this length in the specified column
        // Ensure length is within bounds of the freqTable's row to avoid ArrayIndexOutOfBoundsException
            if (length < frequencyAnimalTable.length) {
                frequencyAnimalTable[length][column]++;
        }
    }
}
    public static int deleteRecord(AnimalChain[] Animal, String key) {
        int hashCode = generateHashCode(key);
        int index = getHashIndex(hashCode);
        if (Animal[index] != null) {
            Animal[index] = null;
            System.out.println("Deleted records for " + key + " at index " + index);
        } else {
            System.out.println("No records found for " + key);
        }
        return hashCode;
    }
    
    public static void printAnimalIndex(AnimalChain[] animalTable, String key) {
        int hashCode = generateHashCode(key);
        int index = getHashIndex(hashCode);
        if (animalTable[index] != null) {
            System.out.println("Index for " + key + ": " + index);
            System.out.println("Animal object at index " + index + ": " + animalTable[index].toString());
        } else {
            System.out.println("No Animal object found for " + key);
        }
    }

    public static void printIndexesWithChainLength(AnimalChain[] animalTable, int chainLength) {
        System.out.println("Indexes where the chain length is " + chainLength + ":");
        for (int i = 0; i < animalTable.length; i++) {
            if (animalTable[i] != null && animalTable[i].getNumberOfNodes() == chainLength) {
                System.out.println("Index: " + i);
            }
        }
    }
    public static void printIndexContents(AnimalChain[] animalTable, int index) {
        if (index >= 0 && index < animalTable.length && animalTable[index] != null) {
            System.out.println("Contents of index " + index + ": " + animalTable[index].toString());
        } else {
            System.out.println("No Animal objects found at index " + index);
        }
    }
}
    
    

    

 

    
   