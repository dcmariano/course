package memorybehaviorarrayslists.application;

import java.util.Scanner;

import memorybehaviorarrayslists.entities.Student;

public class MainApproved {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("How many students will be typed?");
		int n = sc.nextInt();
		Student[] student = new Student[n];
		String approved = "";

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the name, first and second grade of the " + (i + 1) + "º student:");
			sc.nextLine();
			String name = sc.nextLine();
			double firstNote = sc.nextDouble();
			double secondNote = sc.nextDouble();
			student[i] = new Student(name, firstNote, secondNote);

			if ((student[i].getFirstNote() + student[i].getSecondNote()) / 2 >= 6) {
				approved += student[i].getName() + "\n";
			}
		}
		System.out.println("\nApproved Students: \n" + approved);
		sc.close();
	}

}
