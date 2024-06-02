package inheritancepolymorphism.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inheritancepolymorphism.entities.Employee;
import inheritancepolymorphism.entities.OutsourceEmployee;

public class MainEmployee {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of employees: ");
		int numberEmployees = sc.nextInt();
		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < numberEmployees; i++) {

			System.out.print("\nEmployee #" + (i + 1) + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char outsourced = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hours: ");
			double valuePerHour = sc.nextDouble();

			if (outsourced == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				employees.add(new OutsourceEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				employees.add(new Employee(name, hours, valuePerHour));
			}
		}

		System.out.println("\nPAYMENTS:");
		for (Employee i : employees) {
			
			System.out.println(i.getName() + " - $" + String.format("%.2f",i.payment()));
		}
		sc.close();
	}

}
