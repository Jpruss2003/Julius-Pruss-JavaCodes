//Julius Pruss
//4/13/23
//9:00 
//Grades.java
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] studentNames = new String[5];
        int[] exam1Scores = new int[5];
        int[] exam2Scores = new int[5];
		int average;
		String grade = "";
		
        // Prompt for and input student names and exam scores
        inputStudentData(sc, studentNames, exam1Scores, exam2Scores);

        // Print all the names and exam scores
        printStudentData(studentNames, exam1Scores, exam2Scores);

        // Prompt for and process edits for the data
        editStudentData(sc, studentNames, exam1Scores, exam2Scores);

        // Print all the correct data with each student's exam average and grade
        printFinalData(studentNames, exam1Scores, exam2Scores);
    }

    // Method to input student data
    public static void inputStudentData(Scanner sc, String[] studentNames, int[] exam1Scores, int[] exam2Scores) {
        System.out.println("Enter student names and exam scores:");
        for (int i = 0; i < studentNames.length; i++) {
            System.out.print("Student " + (i + 1) + " name: ");
            studentNames[i] = sc.nextLine();
            System.out.print("Exam 1 score: ");
            exam1Scores[i] = sc.nextInt();
            sc.nextLine(); // Consume newline character
            System.out.print("Exam 2 score: ");
            exam2Scores[i] = sc.nextInt();
            sc.nextLine(); // Consume newline character
        }
    }

    // Method to print all names and exam scores
    public static void printStudentData(String[] names, int[] exam1Scores, int[] exam2Scores) {
        System.out.println("Student Names and Exam Scores:");
        System.out.printf("%-20s %-10s %-10s%n", "Name", "Exam 1", "Exam 2");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-20s %-10d %-10d%n", names[i], exam1Scores[i], exam2Scores[i]);
        }
        System.out.println();
    }

    // Method to prompt for and process edits for the data
    public static void editStudentData(Scanner sc, String[] studentNames, int[] exam1Scores, int[] exam2Scores) {
        System.out.println("Enter student number to edit (1-5), or 0 to exit:");
		int studentNumber = sc.nextInt();
        sc.nextLine(); // Consume newline character
	}
        while (studentNumber != 0) {
            if (studentNumber >= 1 && studentNumber <= 5) {	
                System.out.println("Editing student " + studentNumber + " - " + studentNames[studentNumber - 1]);
                System.out.print("New name: ");
                studentNames[studentNumber - 1] = sc.nextLine();
                System.out.print("New Exam 1 score: ");
                exam1Scores[studentNumber - 1] = sc.nextInt();
                sc.nextLine(); // Consume newline character
                System.out.print("New Exam 2 score: ");
                exam2Scores[studentNumber - 1] = sc.nextInt();
                sc.nextLine(); // Consume newline character
                System.out.println("Student " + studentNumber + " data updated.");
                System.out.println();
				System.out.print("Enter student number to edit(1-5), or 0 to exit:");
            } else {
                System.out.println("Invalid student number. Please enter a number between 1 and 5, or 0 to exit.");
            }
			
		}
   public static int calculateAverage(int exam1Score, int exam2Score) {
    return (exam1Score + exam2Score) / 2;
}

// Method to get grade based on average score
	public static String getGrade(int averageScore) {
		if (averageScore >= 90 && averageScore <= 100) {
			return "A";
		}else if (averageScore >= 80 && averageScore < 90) {
			return "B";
    } 	else if (averageScore >= 70 && averageScore < 80) {
			return "C";
    } 	else if (averageScore >= 60 && averageScore < 70) {
			return "D";
    } 	else {
			return "F";
    }
}

// Method to print final data with average and grade
	public static void printFinalData(String[] studentNames, int[] exam1Scores, int[] exam2Scores) {
		System.out.println("Final Data:");
		for (int i = 0; i < studentNames.length; i++) {
			int averageScore = calculateAverage(exam1Scores[i], exam2Scores[i]);
			String grade = getGrade(averageScore);
			System.out.println("Name: " + studentNames[i] + ", Exam 1 Score: " + exam1Scores[i] + ", Exam 2 Score: " + exam2Scores[i] +
                ", Average Score: " + averageScore + ", Grade: " + grade);
    }
}
}
}