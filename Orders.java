//Julius Pruss
//3/22/23
//9:00 class
//Orders.java

import java.util.Scanner;

public class Orders{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String itemCode = "";
		int quantity = 0;
		double total = 0.00;
		double price = 0.00;
		double subtotal;
		
	
		while(true){
			System.out.print("\nPlease enter the product code and quantity: ");
			itemCode = input.next().toUpperCase();
			quantity = input.nextInt();
			while(((!itemCode.equals("ZZZZ")) || ( quantity!=0))){
				break;
			}
			switch(itemCode){
				case "A105":
					price = 13.67;
					break;
				case "A207":
					price = 21.65;
					break;
				case "D671":
					price = 20.55;
					break;
				case "X111":
					price = 39.99;
					break;
				case "X902":
					price = 4.56;
					break;
				case "ZZZZ":
					price = 0.00;
					break;
				default:
					price = -1;
					break;
			}
			if(price == -1){
				System.out.print("\nError. Please re-enter the product code and quantity: ");
			}
			else if(quantity <= -1){
				System.out.print("\nError. Please re-enter the product code and quantity: ");
			}
			else {
				subtotal = price * quantity;
				System.out.printf("\n" + itemCode + quantity + " items" + " your price is: " + "%.2f", subtotal);
				total += subtotal;
			
			}
			System.out.printf("\nTotal:" + "%.2f", total);
			}
			
	}		
}		
		
			
	
			
		

				
			
		