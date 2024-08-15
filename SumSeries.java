//Julius Pruss
//class 9:00
//Date:2/2/23
//SumSeries.java
//SumSeries


import java.util.Scanner;//scanner is in java.util package

public class SumSeries{
	public static void main(String[]args){
		//Create scanner object
		Scanner input = new Scanner(System.in);
		//Variables for the sum
		double n;
		double r;
		//tell the user to enter a positive integer n for the highest power
		//tell the user to enter a real number for ratio
		System.out.print("Enter a positive integer for n(highest power): ");
		n = input.nextDouble();
		System.out.print("Enter a real number for r(ratio): ");
		r = input.nextDouble();
		//equations for the sum and answer
		double sum = n + 1;
		double pow = (double)Math.pow(r, sum);
		double difference = pow - r;
		double variation = r - 1;
		double div = difference / variation;
		//prints the solution
		System.out.printf("Sum is: " + "%.2f", div);
	}
}