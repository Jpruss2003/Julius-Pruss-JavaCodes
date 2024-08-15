// Julius Pruss 
//3/15/2025
//9:00 classs
//SportCenter.java

import java.util.Scanner;

public class SportCenter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char membershipType;
		char peakOrNotPeak;
		char hasConcession;
        double hoursUsed;
		double membershipCost;
		double discount;
		double finalPrice = 0;
		
		

        // Prompt for and input membership type
		
        System.out.print("Enter membership type (N for Non-Member, M for Member, P for Premium Member, E for Elite Member): ");
		membershipType = input.nextLine().toUpperCase().charAt(0);
		while ((membershipType != 'N')&&(membershipType != 'M') && (membershipType != 'P') && (membershipType != 'E')) {
            System.out.print("Please enter a valid input. Enter membership type (N for Non-Member, M for Member, P for Premium Member, E for Elite Member):");
			membershipType = input.nextLine().toUpperCase().charAt(0);
        }
		
        // Prompt for and input peak or off peak usage
		
        System.out.print("Are you peak or off peak? (Y/N): ");
        peakOrNotPeak = input.nextLine().toUpperCase().charAt(0);
        while ((peakOrNotPeak != 'N') && (peakOrNotPeak != 'Y')) {
            System.out.print("Please enter a valid input. Are you peak or off peak? (Y/N): ");
            peakOrNotPeak = input.nextLine().toUpperCase().charAt(0);
        }
		
		
        // Prompt for and input concession status
		
        System.out.print("Do you have any concession? (Y/N): ");
        hasConcession = input.nextLine().toUpperCase().charAt(0);
		while ((hasConcession != 'N') && (hasConcession != 'Y'))  {
            System.out.print("Please enter a valid input. Do you have any concession (Y/N): ");
			hasConcession = input.nextLine().toUpperCase().charAt(0);
        }
		
		 if (hasConcession == 'Y') {
            discount = 'T';
        } else {
            discount = 'F';
        }
        // Prompt for and input hours used
        System.out.print("Enter the number of hours you used the sports center: ");
        hoursUsed = Double.parseDouble(input.nextLine());
		
		
		
		

        // Calculate membership cost based on the input
        switch (membershipType) {
            case 'N':
                if (peakOrNotPeak == 'Y') 
                    membershipCost = 10.0;
                else 
                    membershipCost = 9.0;
				finalPrice = hoursUsed * membershipCost;
				while(hoursUsed > 1){
					finalPrice += 5;
					hoursUsed -= 0.5;
                }
				if(discount=='T')
					finalPrice -= (finalPrice*.10);
				else
					finalPrice = finalPrice;
				
                break;
            case 'M':
                if (peakOrNotPeak == 'Y')
                    membershipCost = 7.5;
                else 
                    membershipCost = 6.5;
				finalPrice = hoursUsed * membershipCost;
				while(hoursUsed > 1){
					finalPrice += 3.50;
					hoursUsed -= 0.5;
                }
				if(discount=='T')
					finalPrice -= (finalPrice*.10);
				else
					finalPrice = finalPrice;
				
                break;
            case 'P':
                if (peakOrNotPeak == 'Y')
                    membershipCost = 5.0;
                else
                    membershipCost = 4.0;
				finalPrice = hoursUsed * membershipCost;
				while(hoursUsed > 1){
					finalPrice += 2;
					hoursUsed -= 0.5;
                }
				if(discount=='T')
					finalPrice -= (finalPrice*.10);
				else
					finalPrice = finalPrice;
				
                break;
            case 'E':
				if(peakOrNotPeak == 'Y')
					membershipCost = 3.5;
				else
					membershipCost = 3.0;
				finalPrice = hoursUsed * membershipCost;
				
				if(discount=='T')
					finalPrice -= (finalPrice*.10);
				else
					finalPrice = finalPrice;
				
                break;
            
        }
		
		
	

        // Print the output

        System.out.printf("Final price: $" + "%.2f", finalPrice);
    }
}
