package introductionobjectorientation.application;

import java.util.Scanner;

import introductionobjectorientation.entities.Student;

public class MainStudent {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		System.out.println("Enter student name");
		student.name = sc.nextLine(); 
				
		do {
			System.out.println("Enter with grade of first, second and third quarter");
			student.firstQuarter = sc.nextDouble();
			student.secondQuarter = sc.nextDouble();
			student.thirdQuarter = sc.nextDouble();

			if (student.firstQuarter > 30 || student.secondQuarter > 35 || student.thirdQuarter > 35) {
				System.out.println(
						"The first grade must be less than or equal to 30 and the second and third grades must be less than or equal to 35. Try again.");
			}

		} while (student.firstQuarter > 30 || student.secondQuarter > 35 || student.thirdQuarter > 35);

		System.out.println(student);

		sc.close();
	}

}
