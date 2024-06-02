package memorybehaviorarrayslists.application;

import java.util.Scanner;

import memorybehaviorarrayslists.entities.People;

public class MainPeoples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many datas will you enter?");
		int n = sc.nextInt();
		People[] people = new People[n];
		double sum = 0;
		double percent = 0.00;
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("\nEnter the " + (i + 1) + "º people:");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Age: ");
			int age = sc.nextInt();
			if (age < 16) {
				percent++;

			}
			System.out.print("Height: ");
			double height = sc.nextDouble();
			people[i] = new People(name, age, height);
			sum += people[i].getHeight();

		}
		System.out.println();
		percent = (percent / n) * 100;
		sum = sum / n;

		System.out.printf("Average height = %.2f", sum);
		System.out.println();
		System.out.printf("People under the age of 16 = %.1f%%%n", percent);

		for (int i = 0; i < n; i++) {
			if (people[i].getAge() < 16) {
				System.out.println(people[i].getName());
			}
		}

		sc.close();
	}

}
