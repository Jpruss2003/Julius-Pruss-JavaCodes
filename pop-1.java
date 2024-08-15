//Julius Pruss
//9:00 
//3/1/2023
//Pop.java

public class pop {
	public static void main(String[] args) {

		int year = 2021;
		double population = 7.888;
		final double POPULATION_PER_CHANGE = 0.012;
		
		while(population < 9.000){
			System.out.printf(year + " " + "%.3f", population);
			System.out.println("");
			population = population + population * POPULATION_PER_CHANGE;
			year += 1;
		}
		System.out.printf(year + " " + "%.3f", population);
	}
}