package composition.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import composition.entities.Department;
import composition.entities.HourContract;
import composition.entities.Worker;
import composition.entities.enums.WorkerLevel;

public class MainWorker {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter department's name: ");
		String department = sc.nextLine();

		System.out.print("Enter work data \n");

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Level: ");
		String level = sc.nextLine();

		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();

		System.out.print("How many contracts to this worker? ");
		int contracts = sc.nextInt();

		System.out.println();

		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));

		for (int i = 0; i < contracts; i++) {
			sc.nextLine();
			System.out.print("Enter contract #" + (i + 1) + " data\n");

			System.out.print("Date (DD/MM/YYYY: ");
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());

			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();

			worker.addContract(new HourContract(date, valuePerHour, duration));
			System.out.println();

		}

		sc.nextLine();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthYear = sc.nextLine();
		System.out.println();
		int month = Integer.parseInt(monthYear.split("/")[0]);
		int year = Integer.parseInt(monthYear.split("/")[1]);

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.print("Income for " + monthYear + ": " + worker.income(year, month));

		sc.close();
	}
}
