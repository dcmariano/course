package memorybehaviorarrayslists.application;

import java.util.Scanner;

import memorybehaviorarrayslists.entities.Rent;

public class MainRent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many rooms will be rented");
		int n = sc.nextInt();
		Rent[] rent = new Rent[9];

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("\nRent #" + i);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			if (rent[room] == null) {
				rent[room] = new Rent(name, email);
				System.out.println("Successfully rented");
			} else {
				do {
					System.out.print("This room is occupied choose another room: ");
					room = sc.nextInt();
					if (rent[room] == null) {
						rent[room] = new Rent(name, email);
						System.out.println("Successfully rented");
					}
				} while (rent[room] == null);
			}

		}

		System.out.println("\nBusy rooms:");
		for (int i = 0; i < 9; i++) {
			if (rent[i] != null) {
				System.out.println(i 
									+ ": " 
									+ rent[i].getName() 
									+ ", " 
									+ rent[i].getEmail());
			}
		}

		sc.close();
	}

}
