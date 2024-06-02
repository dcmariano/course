package memorybehaviorarrayslists.application;

import java.util.Scanner;

public class MainAveragePairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many elements will the vector have? ");
		int n = sc.nextInt();
		int vect[] = new int[n];
		int sum = 0, cont = 0;

		for (int i = 0; i < n; i++) {
			System.out.print("Enter a number: ");
			vect[i] = sc.nextInt();
			if (vect[i] % 2 == 0) {
				cont++;
				sum += vect[i];
			}
		}
		if (cont > 0) {
			double average = sum / cont;
			System.out.println("\nPeer average: " + average);
		} else {
			System.out.println("No even numbers");
		}
		sc.close();

	}

}
