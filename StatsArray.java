//Julius Pruss
//4/11/23
//9:00 class
//StatsArray.java

import java.util.Scanner;

public class StatsArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		int size;   // declares the size of the array
		int arr;    // declares that we are using an array
		int max;    // declares we are the finding the highest number in the array
		double mean;  // declares that we are finding the mean of any number that is from the input from the size of the array
		double variance;  //declares that this variable is for finding the standard deviation first
		double standardDeviation;  // declares in the last variable that we already found the standard deviation equation, we just need to put it in a square root
		int sum = 0;   //declares the sum for the mean in the array
		int num;   // declares the numbers that are in the array already
		int count = 0;  // declares that it will count how many are in the mean after the standard deviation
		
        // Prompt for and input the size of the array
        System.out.print("Enter the size of the array: ");
        size = input.nextInt();

        // Declare and instantiate the array
        arr = new int[size];

        // Prompt for and input the integers to fill the array
        System.out.println("Enter the integers to fill the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        // Calculate and print the highest number in the array
        max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Highest number: " + max);

        // Calculate and print the mean of the numbers in the array
		
        for (num : arr) {
            sum += num;
        }
        mean = (double) sum / size;
        System.out.println("Mean: " + mean);

        // Calculate and print the standard deviation of the numbers in the array
        int sumOfSquares = 0;
        for (num : arr) {
            sumOfSquares += num * num;
        }
        variance = (double) sumOfSquares / size - (mean * mean);
        standardDeviation = Math.sqrt(variance);
        System.out.println("Standard Deviation: " + standardDeviation);

        // Calculate and print how many numbers in the array are within one standard deviation of the mean
        
        for (int num : arr) {
            if (num >= mean - standardDeviation && num <= mean + standardDeviation) {
                count++;
            }
        }
        System.out.println("Numbers within one standard deviation of the mean: " + count);
    }
}	