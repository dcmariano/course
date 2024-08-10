package lambdaexpressions.application;

import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;

import lambdaexpressions.entities.Product;

public class MainComparator {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 1500.0));
		list.add(new Product("Phone", 2000.0));
		list.add(new Product("Notebook", 3000.0));

		// Comparator<Product> comp = new Comparator<Product>() {
		// 		public int compare(Product p1, Product p2) {
		// 			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		// 		}
		// };

		// Comparator<Product> comp = (p1, p2) -> {
		// 		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		// };

		// Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

		// list.sort(new MyComparator());
		// list.sort(comp);

		list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

		for (Product p : list) {
			System.out.println(p);
		}
	}

}
