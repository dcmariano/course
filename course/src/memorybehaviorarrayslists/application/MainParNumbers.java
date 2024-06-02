package memorybehaviorarrayslists.application;

import java.util.Scanner;

public class MainParNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers will you enter?");
		int n = sc.nextInt();
		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter a number: ");
			numbers[i] = sc.nextInt();
		}
		
		int cont = 0;
		System.out.println("\nPair numbers: ");
		for (int i = 0; i < n; i++) {
			if (numbers[i] % 2 == 0) {
				System.out.print(numbers[i] + " ");
				cont++;
			}
		}
		System.out.print("\n\nQuantity of even numbers = " + cont);
		sc.close();
	}

}
