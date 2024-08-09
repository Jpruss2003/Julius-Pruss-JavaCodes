/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cs0048spring2024.assign3;

import java.util.Arrays;


/**
 *
 * @author juliuspruss
 */
public class Assign3 {

    public static void main(String[] args) {
        int initialArraySize = 10;
        int numberOfTests = 10; 

        for (int i = 0; i < numberOfTests; i++) {
            int currentSize = initialArraySize * (int) Math.pow(2, i);

            char[] array = generateRandomSortedCharArray(currentSize);

            System.out.println("\nArray Size: " + currentSize);

            
            int seqSearch = seqSearch(array, 'Z');
            boolean recSeqSearch = recSeqSearch(array, 'Z', 0, array.length -1);
            int binarySearch = binarySearch(array, 'Z', 0, array.length - 1);

            
            System.out.println("Sequential Search comparisons: " + seqSearch);
            System.out.println("Recursive seq search comparisons: " + recSeqSearch);
            System.out.println("Binary search comparisons: " + binarySearch);
        }
    }

    

   public static char[] generateRandomSortedCharArray(int size) {
        char[] charArray = new char[size];
        
        for (int i = 0; i < size; i++) {
            if(i < size / 2) {
                charArray[i] = 'A';
            }
            else
                charArray[i] = 'a';
        }

        
        Arrays.sort(charArray);

        return charArray;
    }

    public static int seqSearch(char [] arr, char target){
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            index++;
            if(arr[i] == target){
                return index;
            }
        }
        return index;
    }
    public static boolean recSeqSearch(char[] arr, char target, int first, int last){
        if(first > last ){
            return false;
    }
        else
            if(arr[last] == (target)){
                return true;
            }
        else
                return recSeqSearch(arr, target, first, last - 1);
    }
    public static int binarySearch(char[] arr, int target, int low, int high){
        if (low > high) {
            
            return 0; 
        }

        int mid = (low + high) / 2;
        
        if (arr[mid] == target) {
            return 1; 
            
        } else if (arr[mid] < target) {
            
            return 1 + binarySearch(arr, target, mid + 1, high);
            
        } else {
            
            return 1 + binarySearch(arr, target, low, mid - 1);
            
        }
    }
}