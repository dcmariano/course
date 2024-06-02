package memorybehaviorarrayslists.application;

import java.util.Scanner;

public class MainPeopleHeight {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number peoples");
		int n = sc.nextInt();
		double[] array = new double[n];
		double aux = 0;

		for (int i = 0; i < n; i++) {
			System.out.print("Enter the " + (i + 1) + "º height: ");
			array[i] = sc.nextDouble();
			aux += array[i];
		}
		aux /= n;
		System.out.println("\nThe average height is: " + String.format("%.2f", aux));

		sc.close();

	}

}
