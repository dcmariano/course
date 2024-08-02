package genericssetmap.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import genericssetmap.entities.Product;
import genericssetmap.services.CalculationService;

public class MainCalculationService {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {
			String line = br.readLine();
			while (line != null) {
				String[] parts = line.split(", ");
				String name = parts[0];
				double value = Double.valueOf(parts[1]);
				list.add(new Product(name, value));
				line = br.readLine();
			}
			Product x = CalculationService.max(list);
			System.out.print("Max: " + x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
