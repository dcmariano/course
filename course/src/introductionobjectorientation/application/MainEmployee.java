package introductionobjectorientation.application;

import java.util.Scanner;

import introductionobjectorientation.entities.Employee;

public class MainEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Employee employee = new Employee();

		System.out.println("Enter the name of the employee");
		employee.name = sc.nextLine();
		System.out.println("Enter the gloss salary of the employee");
		employee.glossSalary = sc.nextDouble();
		System.out.println("Enter the tax of the employee");
		employee.tax = sc.nextDouble();

		System.out.println();
		System.out.println(employee);

		System.out.println();
		System.out.println("Enter the percent increase salary of the employee");
		employee.increaseSalary(sc.nextDouble());

		System.out.println();
		System.out.println(employee);
		
		sc.close();

	}

}
