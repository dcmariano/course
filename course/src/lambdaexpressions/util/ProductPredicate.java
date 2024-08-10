package lambdaexpressions.util;

import java.util.function.Predicate;

import lambdaexpressions.entities.Product;

public class ProductPredicate implements Predicate<Product> {

	@Override
	public boolean test(Product p) {
		return p.getPrice() <= 1500;
	}

}
