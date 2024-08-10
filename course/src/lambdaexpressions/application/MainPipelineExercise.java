package lambdaexpressions.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lambdaexpressions.entities.Product;

public class MainPipelineExercise {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {
			List<Product> products = new ArrayList<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(", ");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				products.add(new Product(name, price));
				line = br.readLine();
			}

			double average = Math.ceil((products.stream()
					.map(x -> x.getPrice())
					.reduce(0.0, (a, b) -> a + b)) / products.size());
			
			System.out.println("Average= " + average);
			
			List<Product> belowAverage = products.stream()
					.filter(x -> x.getPrice() < average)
					.sorted((x ,y) -> x.getName().toUpperCase().compareTo(y.getName().toUpperCase()))
					.collect(Collectors.toList());

			belowAverage.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
