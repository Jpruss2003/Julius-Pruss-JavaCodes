/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cs0048spring2024.assign6;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author juliuspruss
 */
public class Assign6 {

    public static void main(String[] args) {
        int[] test1 = {444, 9, 100000000, 89, 37, 120, 89, 37,
120, 999, 45};
int[] test2 = Arrays.copyOf(test1, test1.length);
int[] test3 = Arrays.copyOf(test1, test1.length);
int[] test4 = Arrays.copyOf(test1, test1.length);
int[] test5 = Arrays.copyOf(test1, test1.length);
int[] test6 = {45, 23, 19, 91, 6, 24, 11, 19, 78, 62, 2,
8, 90, 45, 34, 92, 4, 11, 18, 21, 81, 6};
int[] test7 = Arrays.copyOf(test6, test6.length);
int[] test8 = Arrays.copyOf(test6, test6.length);
int[] test9 = Arrays.copyOf(test6, test6.length);
System.out.println("BUBBLE SORT");
System.out.println("===========");
System.out.println("Before: " + Arrays.toString(test1));
bubbleSort(test1);
System.out.println("After: " + Arrays.toString(test1));
System.out.println("Before: " + Arrays.toString(test6));
bubbleSort(test6);
System.out.println("After: " + Arrays.toString(test6));
System.out.println("\nMINMAX SELECTION SORT");
System.out.println("=====================");
System.out.println("Before: " + Arrays.toString(test2));
minMaxSelSort(test2);
System.out.println("After: " + Arrays.toString(test2));
System.out.println("Before: " + Arrays.toString(test7));
minMaxSelSort(test7);
System.out.println("After: " + Arrays.toString(test7));
System.out.println("\nTWO THIRDS SORT");
System.out.println("===============");
System.out.println("Before: " + Arrays.toString(test3));
twoThirdsSort(test3, 0, test3.length - 1);
System.out.println("After: " + Arrays.toString(test3));
System.out.println("Before: " + Arrays.toString(test8));
twoThirdsSort(test8, 0, test8.length - 1);
System.out.println("After: " + Arrays.toString(test8));
System.out.println("\nRANDOM SORT");
System.out.println("===========");
System.out.println("Before: " + Arrays.toString(test4));
randomSort(test4);
System.out.println("After: " + Arrays.toString(test4));
System.out.println("\nMAX SORT");
System.out.println("===========");
System.out.println("Before: " + Arrays.toString(test5));
maxSort(test5);
System.out.println("After: " + Arrays.toString(test5));
System.out.println("Before: " + Arrays.toString(test9));
maxSort(test9);
System.out.println("After: " + Arrays.toString(test9));
    }
    
    public static void bubbleSort(int[] arr){
        int temp;
        boolean swapped;
        for(int i = 0; i < arr.length - 1; i++){
            swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
            }
        }
            if(swapped == false){
                break;
            }
    }
}
    public static void minMaxSelSort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            // min stores INDEX of smallest item from unsorted part of array
            // max stores index of largest item from unsorted part of array
            int min = i;
            int max = i;
            // Find smallest item in unsorted part of array
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
            }
                else if(arr[j] > arr[max]){
                    max = j;
                }
           }
        // swap the current smallest item into its correct position
            temp = arr[min]; 
            arr[min] = arr[i]; 
            arr[i] = temp; 
            
            //if max is position i after swap from min position, update maximum with new position to the min
            if(max == i){
                max = min;
            }
            
            // swapping the max with the last element in the unsorted part of the array so it can be max value
            temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[max];
            arr[max] = temp;
      }
        
            
        }

    public static void twoThirdsSort(int[] arr, int first, int last){
       if(first < last){
  
        
        if (arr[first] > arr[last]) { 
            int temp = arr[first]; 
            arr[first] = arr[last]; 
            arr[last] = temp; 
        } 
        if(last - first + 1 > 2){
            int temp = (int) Math.ceil((last - first + 1) * (2.0 / 3.0));

            // Recursively sort the first 2/3 of the array
            twoThirdsSort(arr, first, first + temp - 1);

            // Recursively sort the last 2/3 of the array
            twoThirdsSort(arr, last - temp + 1 , last);

            // Recursively sort the first 2/3 of the array again to ensure correctness
            twoThirdsSort(arr, first , first + temp - 1);
        }
        }
    }
    public static void randomSort(int[]arr){
        Random random = new Random();
        int num1; 
        int num2;

        while (!shuffleArray(arr)) {
            num1 = random.nextInt(arr.length);
            num2 = random.nextInt(arr.length );
            
            int temp = arr[num1];
            arr[num1] = arr[num2];
            arr[num2] = temp;
        }
    }
    
        
    public static boolean shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]){
                return false;
            }
            
        }
        return true;
    }
    public static void maxSort(int[] arr){
        int max;

        // Find the maximum value in the array
        max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        //count the number of frequencies size(max + 1) 
        int[] size = new int[max + 1];
        for (int num : arr) {
            size[num]++;
        }

        // then iterate through new array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (size[i] > 0) {
                arr[index++] = i;
                size[i]--;
            }
        }
    }
    }

     
