package lambdaexpressions.application;

import java.util.ArrayList;
import java.util.List;

import lambdaexpressions.entities.Product;
import lambdaexpressions.services.ProductService;

public class MainCreatePredicate {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 1500.0));
		list.add(new Product("Phone", 2000.0));
		list.add(new Product("Notebook", 3000.0));
		list.add(new Product("Tablet", 2100.39));

		double sum = ProductService.filteredSum(list, p -> p.getName().charAt(0) == 'T');

		System.out.println("Sum= $" + String.format("%.2f", sum));
	}

}
