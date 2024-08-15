//Julius Pruss
//9:00 class
//Date: 2/2/23
//SphereCylinder.java

//importing scanner 
import java.util.Scanner;

public class SphereCylinder{
	
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		//my variables that are for my if and else statements
		double calcChoice;     // second option choice in code between 1-2
		double shapeChoice;    // first option choice in code between 1-2
		double sphere;         // first shape selection
		double cylinder;       // second shape selection
		double radius;			// radius of sphere and cylinder
		double volume;  		//calculates the volume of the sphere and cylinder
		double surfaceArea;    // calculates the surfaceArea of the sphere and cylinder
		double height;
		System.out.print("Choose shape: Sphere(1), Cylinder(2)....");
		shapeChoice = input.nextDouble();
		System.out.print("Choose Calculation: Volume(1), Surface Area(2)....");
		calcChoice = input.nextDouble();
		if(shapeChoice==1){
			if(calcChoice==1){
				System.out.print("Enter the Radius: ");
				radius = input.nextDouble();
				volume = (4.0 / 3.0) * Math.PI * (radius * radius * radius); 
				
				System.out.printf("Answer = " + "%.4f", volume);
			}
			else if(calcChoice==2){
				System.out.print("Enter the Radius: ");
				radius = input.nextDouble(); 
				surfaceArea = 4.0 * Math.PI * (radius * radius);
				
			System.out.printf("Answer = " + "%.4f", surfaceArea);
			}
		}
		else if(shapeChoice==2){
			if(calcChoice==2){
				System.out.print("Enter the Radius : ");
				radius = input.nextDouble();
				System.out.print("Enter the Height: ");
				height = input.nextDouble();
				surfaceArea = 2.0 * Math.PI * (radius * height) + 2.0 * Math.PI * (radius * radius);
				
				System.out.printf("Answer = " + "%.4f", surfaceArea);
			}
			else if(calcChoice==1){
				System.out.print("Enter the Radius : ");
				radius = input.nextDouble();
				System.out.print("Enter the Height: ");
				height = input.nextDouble();
				volume = Math.PI * (radius * radius) * height;
				
				System.out.printf("Answer = " + "%.4f", volume);
			}
		}
	}
}
		
	
		
	
