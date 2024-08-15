//Julius Pruss
//3/23/23
//9:00 
//Pyramid.java

import java.util.Scanner;

public class Pyramid{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	
		double display;  // displays the answer from the main and it gets returned from the method display
		double width;   //this will be width for the volume of the pyramid and the surface area of the pyramid
		double height;  // this will be height for the volume and surface of the pyramid
		double volPyr;   // this variable is for method public static double volPyr, it will calculate the volume of a pyramid
		double surfaceAreaPyr;  // this variable is for the method public static double surfaceAreaPyr, it will calculate the surface of a pyramid
		
		
		// It will prompt the user to enter the width of the pyramid
		System.out.print("Enter width of the pyramid: ");
		width = input.nextDouble();
		
		//it will prompt the user to enter the height of the pyramid
		System.out.print("Enter the height of the pyramid: ");
		height = input.nextDouble();
		
		//it will calculate from the methods below to return to the main function
		volPyr = volPyr(width, height);
		surfaceAreaPyr = surfaceAreaPyr(width, height);
		display(volPyr, surfaceAreaPyr);
		
		// It will prompt the user to enter yes or no if they want to continue there program.
		System.out.print("\nDo you want to continue inputing numbers for the volume and surface area? (o for yes and x for no): ");
		String loop = input.next();
		
		//user can input as many times until x is hit on the keyboard, it will exit the code
		while(loop.equalsIgnoreCase("o")){
		//prompts the user to enter a width 
			System.out.print("Enter width of the pyramid: ");
			width = input.nextDouble();
		
		
		//prompts the user to enter a height
			System.out.print("Enter the height of the pyramid: ");
			height = input.nextDouble();
		
			
			volPyr = volPyr(width, height);
			surfaceAreaPyr = surfaceAreaPyr(width, height);
			display(volPyr, surfaceAreaPyr);
			
			System.out.print("\n Do you want to continue inputing numbers for the volume and surface area? (o for yes and x for no)");
			loop = input.next();
		}
	}
		// the method for calculating the volume of the pyramid, it will return the to main function, as well as, the loop
		public static double volPyr(double w, double h){
			double volPyr = (Math.pow (w, 2) * h ) / 3;
			return volPyr;
		}
		//the method for calculating surface area of the pyramid, it will return the main function to the main method, as well as the loop
		public static double surfaceAreaPyr(double w, double h){
			double surfaceAreaPyr = Math.pow(w, 2) + 2 * w * Math.sqrt(Math.pow(w, 2) / 4 + Math.pow(h, 2));
			return surfaceAreaPyr;
		}
		//the method for displaying the final volume and surface area of the pyramid
		public static void display(double volPyr , double surfaceAreaPyr){
			System.out.print("\n The total volume of the pyramid will be: " + volPyr);
			System.out.print("\n The total surface area of the pyramid will be: " + surfaceAreaPyr);
		}
}
	