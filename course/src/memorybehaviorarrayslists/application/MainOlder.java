package memorybehaviorarrayslists.application;

import java.util.Scanner;

import memorybehaviorarrayslists.entities.People;

public class MainOlder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("How many people will you enter? ");
		int n = sc.nextInt();
		People[] people = new People[n];
		String older = null;
		int olderAge = 0;

		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println((i + 1) + " person data:");
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Age: ");
			int age = sc.nextInt();
			System.out.println();
			people[i] = new People(name, age);
			if (people[i].getAge() > olderAge) {
				olderAge = people[i].getAge();
				older = people[i].getName();
			}
		}

		System.out.println("Older person: " + older);

		sc.close();
	}

}
