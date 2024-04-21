/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0048spring2024.assign1;

/**
 *
 * @author juliuspruss
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String employeeId;
    private double payRate;
    

    public Employee(String f, String l, String e, double p){
        firstName = f;
        lastName = l;
        employeeId = e;
        payRate = p;
       
}
    public void setFirstName(String f){
        firstName = f;
    }
    public void setLastName(String l){
        lastName = l;
    }
    public void setEmployeeId(String e){
        employeeId = e;
        
    }
    public void setPayRate(double p){
        payRate = p;
    }
    public String getFirstName(){
        return firstName;
        
}
    public String getLastName(){
        return lastName;
        
}
    public String getEmployeeId(){
        
        return employeeId;
    }
    public double getPayRate(){
        
        return payRate;
    }
    public String toString(){
        
        return("first name: " + firstName + " last name: " + lastName + " employee id: " + employeeId + " pay rate: " + payRate) ;
    }
}
