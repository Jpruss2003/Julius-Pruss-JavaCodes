import java.util.Scanner;

public class CalPi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
		int k;
		double pi = 0.00;
		double numerator;
		double denominator;
		
        System.out.print("Enter the number of terms to use in the calculation: ");
        k = scanner.nextInt();
        pi = calculatePi(k);
        System.out.println("Pi calculated using " + k + " terms is: " + pi);
    }

    public static double calculatePi(int k) {
        for (int i = 0; i < k; i++) {
            numerator = 4.0 * Math.pow(-1, i);
            denominator = (2 * i + 1);
            pi += numerator / denominator;
        }
        return pi;
    }
}
