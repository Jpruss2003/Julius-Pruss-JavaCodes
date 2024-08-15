//Julius Pruss
//9:00 class
//date: 2/16/23
//EmployeeID.java

//imports scanner from java package
import java.util.Scanner;

public class EmployeeID {
	
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		
		String employeeName = "";		//Employees last name 
		int lengthName = 0; //employees length name
		String empDepart = "";  //Employees department
		String empBirthmonth = "";  //Employess birth date 
		String departAbreviation = "";  // the department abbreviation
		String employeeID = ""; //varible that will go in the strings to concatenate
		char firstchar = 0;
		
		//input
		System.out.print("Enter last name: ");
		employeeName = input.nextLine();
		employeeName = employeeName.toUpperCase();
		lengthName = employeeName.length();
		firstchar = employeeName.charAt(0);
		System.out.print("Enter department (3 abbreviation code): ");
		departAbreviation = input.nextLine();
		departAbreviation = departAbreviation.toUpperCase();
		System.out.print("Enter birth month ( 3 abbreviation code): ");
		empBirthmonth = input.nextLine();
		empBirthmonth = empBirthmonth.toUpperCase();
		
		//calculations
		switch(firstchar){
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				employeeID = "V";
				break;
			default:
				employeeID = "C";
				break;
		}	
		switch(departAbreviation){
			case "ACC":
				employeeID = employeeID + "101";
				break;
			case "HRS":
				employeeID = employeeID + "102";
				break;
			case "SAL":
				employeeID = employeeID + "103";
				break;
			case "FIN":
				employeeID = employeeID + "104";
				break;
			case "ADV":
				employeeID = employeeID + "105";
				break;
			case "COM":
				employeeID = employeeID + "106";
			default:
				employeeID = employeeID + "110";
				break;
		}
		switch(empBirthmonth){
			case "JAN":
				employeeID = employeeID + "01";
				break;
			case "FEB":
				employeeID = employeeID + "01";
				break;
			case "MAR":
				employeeID = employeeID + "02";
				break;
			case "APR":
				employeeID = employeeID + "02";
				break;
			case "MAY":
				employeeID = employeeID + "03";
				break;
			case "JUN":
				employeeID = employeeID + "03";
				break;
			case "JUL":
				employeeID = employeeID + "04";
				break;
			case "AUG":
				employeeID = employeeID + "04";
				break;
			case "SEP":
				employeeID = employeeID + "05";
				break;
			case "OCT":
				employeeID = employeeID + "05";
				break;
			case "NOV":
				employeeID = employeeID + "06";
				break;
			case "DEC":
				employeeID = employeeID + "06";
				break;
		}	
				
		switch(lengthName){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				employeeID = employeeID + "0" + lengthName;
				break;
			default:
				employeeID = employeeID + lengthName;
				break;
		}
		//output
		System.out.println("Here is your employee ID: " + employeeID);
			
	}
}	