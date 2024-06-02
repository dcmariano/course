package memorybehaviorarrayslists.application;

import java.util.Scanner;

public class MainBelowAverage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many values ​​will each vector have? ");
		int n = sc.nextInt();
		double[] vect = new double[n];
		double sum = 0;

		for (int i = 0; i < n; i++) {
			System.out.print("Enter a number: ");
			vect[i] = sc.nextDouble();
			sum += vect[i];
		}
		double average = sum / n;
		System.out.printf("\nVector mean = %.3f\n" , average);
		System.out.println("Elements below average: ");
		for (int i=0; i<n; i++) {
	        if (vect[i] < average) {
	        	System.out.printf("%.1f\n", vect[i]);
	        }
	    }
		
		sc.close();
		
	}

}
