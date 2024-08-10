package lambdaexpressions.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lambdaexpressions.entities.Employee;

public class MainFixationExercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the salary: ");
		double salarySearch = sc.nextDouble();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {
			List<Employee> employees = new ArrayList<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(", ");
				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				employees.add(new Employee(name, email, salary));
				line = br.readLine();
			}

			double averageSalary = Math.ceil(employees.stream()
					.map(e -> e.getSalary())
					.reduce(0.0, (a, b) -> a + b)/ employees.size());
			
			Comparator<String> comparatorEmails = (x, y) -> x.compareTo(y);

			List<String> emails = employees.stream()
					.filter(e -> e.getSalary() > salarySearch)
					.map(e -> e.getEmail())
					.sorted(comparatorEmails.reversed())
					.collect(Collectors.toList());
			
			List<String> names = employees.stream()
					.filter(e -> e.getSalary() < averageSalary)
					.map(e -> e.getName())
					.sorted((x, y) -> x.compareTo(y))
					.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than $" + String.format("%.2f", salarySearch));
			emails.forEach(System.out::println);
			
			System.out.println();
			
			System.out.println("Names of people whose salary is less than $" + String.format("%.2f", averageSalary));
			names.forEach(System.out::println);
			
			double sum = employees.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getSalary())
					.reduce(0.0, (a, b) -> a + b)/ employees.size();
			
			System.out.println();
			
			System.out.println("Sum of salaries of people whose name starts with 'M': $" + String.format("%.2f", sum));
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} finally {
			sc.close();
		}
	}
}
