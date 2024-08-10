package lambdaexpressions.application;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;

import lambdaexpressions.entities.Product;
//import lambdaexpressions.util.ProductPredicate;

public class MainPredicate {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 1500.0));
		list.add(new Product("Phone", 2000.0));
		list.add(new Product("Notebook", 3000.0));

		double min = 1500;
		//Predicate<Product> pred = p -> p.getPrice() <= min;

		//list.removeIf(new ProductPredicate());
		//list.removeIf(Product::staticProductPredicate);
		//list.removeIf(Product::nonStaticProductPredicate);
		//list.removeIf(pred);

		list.removeIf(p -> p.getPrice() <= min);

		for (Product p : list) {
			System.out.println(p.toString());
		}
	}
}
