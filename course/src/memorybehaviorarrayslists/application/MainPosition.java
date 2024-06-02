package memorybehaviorarrayslists.application;

import java.util.Scanner;

public class MainPosition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers will you enter?");
		int n = sc.nextInt();
		double[] vect = new double[n];
		double bigger = vect[0];
		int position = 0;
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter a number");
			vect[i] = sc.nextDouble();
			if (vect[i] > bigger) {
				bigger = vect[i];
				position = i;
			}
		}
		System.out.println("\nHighest value: " + bigger);
		System.out.println("Position of highest value: " + position);


		sc.close();
	}

}
