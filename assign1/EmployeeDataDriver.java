/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0048spring2024.assign1;

/**
 *
 * @author juliuspruss
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeDataDriver {
    
     static ArrayList<Employee> employeeList = new ArrayList<>();
     
     public static void main(String[] args){
        readData();
         
        System.out.println("Number of Employees: " + employeeList.size());
            
        System.out.println("Employee at index 93: " + employeeList.get(93));
        
        
        System.out.println("Employee removed at index 58: " + employeeList.remove(58));
        System.out.println(employeeList.get(58));
        
         
        int countBetween = countBetween(13, 15);
        System.out.println("Employes between 13$ and 15$ are: " + countBetween);
        
        printNamesBetween(15.50, 18);
        
        deleteName("Romeo Myers");
        
        printNames(100, employeeList.size()- 1);
        
    }
     
     public static void readData(){
         try{
             Scanner fileInput = new Scanner(new File("EmployeeData.txt"));
             while(fileInput.hasNext()){
                 String firstName = fileInput.next();
                 String lastName = fileInput.next();
                 String employeeId = fileInput.next();
                 double payRate = fileInput.nextDouble();
                 Employee employee = new Employee(firstName, lastName, employeeId, payRate);
                 employeeList.add(employee);
             }
            fileInput.close();
         } catch(FileNotFoundException e){
                System.out.println("Exception has been handled");
                System.exit(0);
         }
                
         }
    public static int countBetween(double lowerPayRate, double upperPayRate){
        Iterator<Employee> iterator = employeeList.iterator();
        int count = 0;
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getPayRate() >= lowerPayRate && employee.getPayRate() <= upperPayRate ){
                count++;
            }
        }
        return count;
    }
    public static void printNamesBetween(double lowerPayRate, double upperPayRate){
        Iterator<Employee> iterator = employeeList.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getPayRate() >= lowerPayRate && employee.getPayRate() <= upperPayRate ){
                System.out.println(employee.getFirstName());
                System.out.println(employee.getLastName());
               
    }
    }
}
    public static void deleteName(String employeeName){
        
        Iterator<Employee> iterator = employeeList.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            String name = employee.getFirstName() + " " + employee.getLastName();
            if(name.equals(employeeName)){
                employeeList.remove(employee);
                break;
            }
        }
    }   

    public static void printNames(int lowerIndex, int upperIndex){
        for(int i = lowerIndex; i <= upperIndex; i++){
            System.out.println(employeeList.get(i));
    }
}

}


