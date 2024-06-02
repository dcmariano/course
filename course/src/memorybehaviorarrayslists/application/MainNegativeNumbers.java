package memorybehaviorarrayslists.application;

import java.util.Scanner;

public class MainNegativeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers will you enter?");
		int n = sc.nextInt();
		double[] vect = new double[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter a number: ");
			vect[i] = sc.nextDouble();
			
		}
		System.out.println("Negative Numbers");
		for (int i = 0; i < n; i++) {
			if (vect[i] < 0) {
				System.out.println(vect[i]);
			}
			
		}

		sc.close();
	}

}
