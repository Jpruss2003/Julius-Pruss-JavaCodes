/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs0048spring2024.assign5;

/**
 *
 * @author juliuspruss
 */
public class Ercase implements Comparable<Ercase>{
    private Patient patient;
    private int priority;
    private int timeWaiting;
    
    public Ercase(Patient r, int p, int t){
        patient = r;
        priority = p;
        timeWaiting = t;
}
    public Patient getPatient(){
        return patient;
    }
    public int getPriority(){
        return priority;
    }
    public int getTimeWaiting(){
        return timeWaiting;
    }
    public void SetPatient(Patient r){
        patient = r;
    }
    public void setPriority(int p){
        priority = p;
    }
    public void setTimeWaiting(int t){
        timeWaiting = t;
    }
    public int compareTo(Ercase c){
        if(c.getPriority() > this.getPriority()){
            return -1; 
        }
        else{
            if(c.getPriority() < this.getPriority()){
                return 1;
            }
            else
                return 0;
            }
        }
    public String toString(){
        return("Patient name : "+ patient + "Priority level: " + priority + "Time Waiting : " + timeWaiting);
    }
}
    

