package lambdaexpressions.util;

import java.util.Comparator;

import lambdaexpressions.entities.Product;

public class MyComparator implements Comparator<Product> {

	public int compare(Product p1, Product p2) {
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
	}

}
