/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cs0048spring2024.assign5;

/**
 *
 * @author juliuspruss
 */
import java.io.BufferedReader; 
import java.util.Random; 
import java.util.Scanner; 
import java.util.PriorityQueue; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
import java.time.DateTimeException; 
import java.time.LocalDate; 

  

public class Assign5 {
    int totalPatientsArrived;
    int totalPatientsSeen;
    int totalWaitTime;
   
    PriorityQueue<Ercase> waitingRoom = new PriorityQueue<>();
    public static void main(String[] args) throws FileNotFoundException { 
        PriorityQueue<Ercase> waitingRoom = new PriorityQueue<>(); 
        System.out.println("Simulation part 1"); 
        System.out.println("The Priority Queue is being set up for 5 intial cases..."); 
        Assign5 emergencyRoom = new Assign5(); 
        emergencyRoom.readPatientData("PatientData.txt");
        
        emergencyRoom.simulateER(1);
        // First part of the simulation
        System.out.println("First part of the simulation:");
        emergencyRoom.simulateER(10);

        // Second part of the simulation
        System.out.println("\nSecond part of the simulation:");
        emergencyRoom = new Assign5();
        emergencyRoom.readPatientData("PatientData.txt");
        emergencyRoom.simulateER(100);
        emergencyRoom.printSecondPart();
}
     
//I made this so I could catch all my Exceptions and handle them 
   public void readPatientData(String filename) {
        PriorityQueue<Ercase> waitingRoom = new PriorityQueue<>(); 
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" , ");
                if (parts.length == 7) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    String patientID = parts[2];
                    int year = Integer.parseInt(parts[3]);
                    int month = Integer.parseInt(parts[4]);
                    int day = Integer.parseInt(parts[5]);
                    int priority = Integer.parseInt(parts[6]);
                    // Validate patientID and date before creating Patient object
                    if (isValidPatientID(patientID)) {
                        try {
                            LocalDate dob = LocalDate.of(year, month, day);
                            Patient patient = new Patient(firstName, lastName, patientID, dob);
                            waitingRoom.offer(new Ercase(patient, priority,0));
                        } catch (DateTimeException e) {
                            System.out.println("Invalid date for patient: " + firstName + " " + lastName);
                        }
                    } else {
                        System.out.println("Invalid patient ID for patient " + firstName + " " + lastName);
                    }
                } else {
                    System.out.println("Enter the waiting room: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to simulate the ER operations for the specified number of cycles
    public void simulateER(int cycles) {
        for (int i = 1; i <= cycles; i++) {
            System.out.println("Cycle " + i + ":");
            handleArrivals();
            handleDepartures();
        }
    }

    // Method to handle patient arrivals
    public void handleArrivals() {
        PriorityQueue<Ercase> waitingRoom = new PriorityQueue<>(); 
        double[] arrivalProbabilities = {0.2, 0.3, 0.3, 0.2}; // Probabilities of 0, 1, 2, or 3 patients arriving
        int arrivals = getRandomEventCount(arrivalProbabilities);
        System.out.println("Patients arrived: " + arrivals);
        for (int i = 0; i < arrivals; i++) {
            // Add a new patient to the waiting room with a random priority
            waitingRoom.offer(generateRandomERCase());
        }
    }

    // Method to handle patient departures
    public void handleDepartures() {
        PriorityQueue<Ercase> waitingRoom = new PriorityQueue<>(); 
        double[] departureProbabilities = {0.25, 0.5, 0.25}; // Probabilities of 0, 1, or 2 patients leaving
        int departures = getRandomEventCount(departureProbabilities);
        System.out.println("Patients seen and left: " + departures);
        for (int i = 0; i < departures; i++) {
            // Remove the highest priority patient from the waiting room
            Ercase seenPatient = waitingRoom.poll();
            if (seenPatient != null) {
                System.out.println("Patient " + seenPatient.getPatient().getFirstName() + " " + seenPatient.getPatient().getLastName() + " seen and left." + seenPatient.getPriority() + " " + seenPatient.getTimeWaiting());
            }
        }
    }

    // Method to generate a random ERCase for testing
    public Ercase generateRandomERCase() {
        String[] firstNames = {"John", "Jane", "Bob", "Alice"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Brown"};
        String[] patientIDs = {"1234567", "2345678", "3456789", "4567890"};
        LocalDate dob = LocalDate.of(1990, 1, 1); // Dummy DOB
        int priority = (int) (Math.random() * 10) + 1; // Random priority from 1 to 10
        int index = (int) (Math.random() * firstNames.length);
        Patient patient = new Patient(firstNames[index], lastNames[index], patientIDs[index], dob);
        return new Ercase(patient, priority, 0);
    }

    // Method to get a random event count based on probabilities
    public int getRandomEventCount(double[] probabilities) {
        double rand = Math.random();
        double cumulativeProbability = 0.0;
        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProbability += probabilities[i];
            if (rand < cumulativeProbability) {
                return i; // Return the index of the probability that was surpassed
            }
        }
        return probabilities.length - 1; // Default to the last event count
    }

    // Method to validate patient ID (7 digits, cannot begin with 0)
    public boolean isValidPatientID(String patientID) {
        return patientID.matches("[1-9]\\d{6}");
    }
    public void printSecondPart() {
        System.out.println("Summary Data:");
        System.out.println("Total patients arrived at the ER: " + totalPatientsArrived);
        System.out.println("Total patients seen: " + totalPatientsSeen);
        if (totalPatientsSeen > 0) {
            double averageWaitTime = (double) totalWaitTime / totalPatientsSeen;
            System.out.println("Average wait time for patients who have been seen: " + averageWaitTime);
        } else {
            System.out.println("Average wait time: No patients seen yet.");
        }
    }
}