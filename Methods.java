//Julius Pruss
//3/30/23
//9:00 class
//Method.java

import java.util.Scanner;

public class Methods{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		
		
		double length;
		double width;
		double shortSide;
		double shortSide2;
		double hypotenuseOfRTriangle;
		double areaOfRTriangle;
		double perimOfRTriangle;
		double areaOfRect;
		double perimOfRect;
		double lengthOfDiagOfRect;
		double areaOfSquare;
		double perimOfSquare;
		double lengthOfDiagOfSquare;
		
		while(true){
			System.out.print("\nPlease choose which calculation you would want to complete: a(Hypotenuse of right triangle), b(Area of right triangle), c(perimeter of right triangle), d(area of a rectangle), e(perimeter of rectangle), f(length of diagonal of a rectangle), g(area of a square), h(perimeter of square), i(length of diagonal of a square), x(to close out the program): ");		
			String calculations = input.next();
		
			if(calculations == "x"){
				break;
			}
			
			switch(calculations){
				case "a":
					System.out.print("\nEnter the first side of the right triangle: ");
					shortSide = input.nextDouble();
					System.out.print("\nEnter the second side of the right triangle: ");
					shortSide2 = input.nextDouble();
					hypotenuseOfRTriangle = hypotenuseOfRTriangle(shortSide, shortSide2);
					System.out.printf("\nThe hypotenuse of the right triangle will be: " + "%.3f", hypotenuseOfRTriangle);
					break;
				case "b":
					System.out.print("\nEnter the first side of the right triangle: ");
					shortSide = input.nextDouble();
					System.out.print("\nEnter the second side of the right triangle: ");
					shortSide2 = input.nextDouble();
					areaOfRTriangle = areaOfRTriangle(shortSide, shortSide2);
					System.out.printf("\nThe area of the right triangle will be: " + "%.3f", areaOfRTriangle);
					break;
				case "c":
					System.out.print("\nEnter the first side of the right triangle: ");
					shortSide = input.nextDouble();
					System.out.print("\nEnter the second side of the right triangle: ");
					shortSide2 = input.nextDouble();
					perimOfRTriangle = perimOfRTriangle(shortSide, shortSide2);
					System.out.printf("\nThe perimeter of the right triangle will be: " + "%.3f", perimOfRTriangle);
					break;
				case "d":
					System.out.print("\nEnter the length of the area of the rectangle rectangle: ");
					length = input.nextDouble();
					System.out.print("\nEnter the width of the area of the rectangle: ");
					width = input.nextDouble();
					areaOfRect = areaOfRect(length, width);
					System.out.printf("\nThe area of the rectangle will be: " + "%.3f", areaOfRect);
					break;
				case "e":
					System.out.print("\nEnter the length of the perimeter of the rectangle: ");
					length = input.nextDouble();
					System.out.print("\nEnter the width of the perimeter of the rectangle: ");
					width = input.nextDouble();
					perimOfRect = perimOfRect(length, width);
					System.out.printf("\nThe perimeter of the rectangle will be: " + "%.3f", perimOfRect);
					break;
				case "f":
					System.out.print("\nEnter the length for the diagonal of the rectangle: ");
					length = input.nextDouble();
					System.out.print("\nEnter the width for the diagonal of the rectangle: ");
					width = input.nextDouble();
					lengthOfDiagOfRect = Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
					System.out.printf("\nThe length of the diagonal of a rectangle will be: " + "%.3f", lengthOfDiagOfRect);
					break;
				case "g":
					System.out.print("\nEnter the length for the area of square: ");
					length = input.nextDouble();
					areaOfSquare = Math.pow(length, 2);
					System.out.printf("\nThe area of the square will be: " + "%.3f", areaOfSquare);
					break;
				case "h":
					System.out.print("\nEnter length for the perimeter of the square: ");
					length = input.nextDouble();
					perimOfSquare = 4 * length;
					System.out.printf("\nThe perimeter of the square will be: " + "%.3f", perimOfSquare);
					break;
				case "i":
					System.out.print("\nEnter the length of the diagonal of the square: ");
					length = input.nextDouble();
					lengthOfDiagOfSquare = length * Math.sqrt(2);
					System.out.printf("\nThe length of the diagonal of a square will be: " + "%.3f", lengthOfDiagOfSquare);
					break;
					
				default:
					System.out.printf("\nExit Program");
					System.exit(0);
					break;
			}
			
		}
	}
		
		public static double hypotenuseOfRTriangle(double s1, double s2){
			double hypotenuseOfRTriangle = Math.pow(s1, 2) + Math.pow(s2, 2);
			return hypotenuseOfRTriangle;
		}
		public static double areaOfRTriangle(double s1, double s2){
			double areaOfRTriangle = (s1 * s2) / 2;
			return areaOfRTriangle;
		}
		public static double perimOfRTriangle(double s1, double s2){
			double perimOfRTriangle = s1 + s2 + Math.sqrt(Math.pow(s1, 2) + Math.pow(s2, 2));
			return perimOfRTriangle;
		}
		public static double areaOfRect(double l, double w){
			double areaOfRect = l * w;
			return areaOfRect;
		}
		public static double perimOfRect(double l, double w){
			double perimOfRect = 2 * (l + w);
			return perimOfRect;
		}
}