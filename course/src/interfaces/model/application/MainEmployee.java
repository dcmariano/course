package interfaces.model.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.model.entities.Employee;

public class MainEmployee {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {
			String line = br.readLine();
			while (line != null) {
				String[] parts = line.split(", ");
				String name = parts[0];
				double salary = Double.valueOf(parts[1]);
				employees.add(new Employee(name, salary));
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		Collections.sort(employees);

		System.out.println("Employees");
		for (Employee e : employees) {
			System.out.println(e.toString());
		}

	}

}
