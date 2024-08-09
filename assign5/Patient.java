/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0048spring2024.assign5;

import java.time.LocalDate;

/**
 *
 * @author juliuspruss
 */
public class Patient {
    private String firstName;
    private String lastName;
    private String patientId;
    private LocalDate DOB;

    public Patient(String f, String l, String p, LocalDate d) {
        firstName = f;
        lastName = l;
        patientId = p;
        if(p.length() != 7 || p.charAt(0) == '0'){
            throw new IllegalStateException();
            
    }
        DOB = d;
}
    public String getFirstName(){
        return firstName;

}
    public String getLastName(){
        return lastName;
        
    }
    public String getPatientId(){
        return patientId;
        
    }
    public LocalDate getDOB(){
        return DOB;
        
    }
    public void setFirstName(String f){
        firstName = f;
    }
    public void setLastName(String l){
        lastName = l;
    }
    public void setPatientId(String p){
        patientId = p;
    }
    public void setDOB(LocalDate d){
        DOB = d;
    }
    public String toString(){
        return("first name: " + firstName + " last name: " + lastName + "patients Id number: " + patientId + " patients date of birth: " + DOB);
    }
}
