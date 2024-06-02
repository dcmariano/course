package memorybehaviorarrayslists.application;

import java.util.Scanner;

public class MainValuesSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers will you enter? ");
		int n = sc.nextInt();
		double[] vect = new double[n];
		double sum = 0;

		for (int i = 0; i < n; i++) {
			System.out.print("Enter a number: ");
			vect[i] = sc.nextDouble();
		}

		System.out.println();
		System.out.print("Values = ");
		for (int i = 0; i < n; i++) {
			System.out.printf("%.2f ", vect[i]);
			sum += vect[i];
		}
		System.out.printf("\nSum = %.2f \n", sum);
		System.out.printf("Average = %.2f ", sum / n);

		sc.close();
	}

}
