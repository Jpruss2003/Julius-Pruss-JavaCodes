//Julius Pruss
//9:00 class
//date: 2/9/23
//CityTax.java

//importing java scanner package
import java.util.Scanner;

public class CityTax{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		//my variables for the program
		double income;       //the income value for the person inputing how much total income they make
		double valueProp;    //the value of there property
		double payerAge;          //How old they are and how much they can get from the tax credit
		double incomeTax = 0;   //the amount of income tax they are receiveing because of how much they make
		double propertyTax;  //the amount of property tax they are having from there property
		double taxCredit = 0;    //the amount of tax credit they could receive because of there age
		double totalTax = 0.00; // the total amount of tax credit they receive from all 3 of variables I have listed above this one
		final double LOWEST_TAX_RATE = .005;  // the lowest amount of tax rate between 10,000 to 40,000 dollars
		final double MIDDLE_TAX_RATE = .01;  //the middle rate of tax between 40,000 to 100,000 dollars
		final double HIGHEST_TAX_RATE = .015; // the highest tax rate, which is over 100,000 dollars
		final double MOST_VALUABLE_TAX_RATE = .011;  //the most valuable tax rate is the tax payers most valuble property
		
		//Inputs for the users 
		System.out.print("Enter income amount ($) ");
		income = input.nextDouble();
		System.out.print("Enter value of Property ($) ");
		valueProp = input.nextDouble();
		System.out.print("Enter Age: ");
		payerAge = input.nextDouble();
		//Calculations
		if(income >= 0 && income <= 10000)
			incomeTax = 0;
		else if(income >= 10000 && income <= 40000)
			incomeTax = (income - 10000 ) * LOWEST_TAX_RATE;
		else if(income >= 40000 && income <= 100000)
			incomeTax = (30000 * LOWEST_TAX_RATE ) + ((income - 40000) * MIDDLE_TAX_RATE);
		else if(income >= 100000)
			incomeTax = (30000 * LOWEST_TAX_RATE ) + ((60000) * MIDDLE_TAX_RATE) + ((income - 100000) * HIGHEST_TAX_RATE);
		
		propertyTax = valueProp * MOST_VALUABLE_TAX_RATE;
		
		if(((payerAge % 3 == 0) ^ (payerAge % 5 == 0)) && (!((payerAge % 3 == 0) ^ (payerAge % 5 == 0))))
			taxCredit = 750;
		
		if(totalTax <=0)
			totalTax = 0;
		
		
		totalTax = incomeTax + propertyTax - taxCredit;
		
		//outputs
		System.out.printf("Income Tax : " + "%.2f" , incomeTax);
		System.out.println();
		System.out.printf("Property Tax : " + "%.2f" , propertyTax);
		System.out.println();
		System.out.printf("Tax Credit : " + "%.2f" , taxCredit);
		System.out.println();
		System.out.printf("Total Tax Credit : " + "%.2f" , totalTax);
		
	}
}