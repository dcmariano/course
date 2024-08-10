package lambdaexpressions.services;

import java.util.List;
import java.util.function.Predicate;

import lambdaexpressions.entities.Product;

public class ProductService {

	public static double filteredSum(List<Product> list, Predicate<Product> predicate) {
		double sum = 0.0;
		for (Product p : list) {
			if (predicate.test(p)) {
				sum += p.getPrice();
			}
		}
		return sum;
	}

}
