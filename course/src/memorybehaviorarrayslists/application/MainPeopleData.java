package memorybehaviorarrayslists.application;

import java.util.Scanner;

import memorybehaviorarrayslists.entities.People;

public class MainPeopleData {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("How many people will be included? ");
		int n = sc.nextInt();
		People[] people = new People[n];
		double smaller = 100;
		double larger = 0;
		double sumHeight = 0;
		int numberMen = 0;
		int numberWoman = 0;

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the height and gender of the " + (i + 1) + "º person: ");
			double height = sc.nextDouble();
			char gender = sc.next().charAt(0);
			people[i] = new People(height, gender);

			if (people[i].getHeight() < smaller) {
				smaller = people[i].getHeight();
			}

			if (people[i].getHeight() > larger) {
				larger = people[i].getHeight();
			}

			if (people[i].getGender() == 'F' || people[i].getGender() == 'f' ) {
				sumHeight += people[i].getHeight();
				numberWoman++;
			}

			if (people[i].getGender() == 'M' || people[i].getGender() == 'm') {
				numberMen++;
			}

		}

		System.out.print("\nShorter height = " + smaller);

		System.out.print("\nGreater height = " + larger);

		System.out.printf("\nAverage height of women = %.2f", (sumHeight / numberWoman));
		
		System.out.println("\nNumber of men = " + numberMen);

		sc.close();
	}

}
