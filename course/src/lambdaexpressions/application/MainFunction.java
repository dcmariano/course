package lambdaexpressions.application;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Function;
import java.util.stream.Collectors;

import lambdaexpressions.entities.Product;
//import lambdaexpressions.util.UpperCaseName;

public class MainFunction {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 1500.0));
		list.add(new Product("Phone", 2000.0));
		list.add(new Product("Notebook", 3000.0));

		// List<String> names = list.stream().map(new
		// UpperCaseName()).collect(Collectors.toList());
		// List<String> names =
		// list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
		// List<String> names =
		// list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

		//Function<Product, String> func = p -> p.getName().toUpperCase();
		//List<String> names = list.stream().map(func).collect(Collectors.toList());
		
		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

		names.forEach(System.out::println);
	}

}
