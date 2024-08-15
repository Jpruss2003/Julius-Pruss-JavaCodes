// Julius Pruss
//9:00
//3/1/23
//SumSquares.java
	
import java.util.Scanner;
import java.lang.Math;

public class SumSquares{
    public static void main(String[] args){
		
        Scanner input = new Scanner(System.in);
		
        int oddInt;            // integer for my odd integers to be only entered into the program
		int i = 1;             // i is the variable that has to be increasing by one to work
        int total = 0;         // the total of the entire code 
		
        //inputs
        System.out.print("Enter an odd positive integer: ");
		oddInt = input.nextInt();
		System.out.print("Enter an odd positive integer: ");
		oddInt = input.nextInt();
		System.out.print("Enter an odd positive integer: ");
		oddInt = input.nextInt();
		System.out.print("Enter an odd positive integer: ");
		oddInt = input.nextInt();
		//calculatins
        while (oddInt % 2 == 0 || oddInt < 1);

        

        while (i <= oddInt) {
            total += Math.pow(i, 2);
            i += 2;
        }
		//output
        System.out.println("The sum of the squares of all odd integers from 1 to " + oddInt + " is: " + total);
    }
}
