package lambdaexpressions.application;

import java.util.ArrayList;
import java.util.List;
// import java.util.function.Consumer;

import lambdaexpressions.entities.Product;
// import lambdaexpressions.util.PriceUpdate;

public class MainConsumer {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 1500.0));
		list.add(new Product("Phone", 2000.0));
		list.add(new Product("Notebook", 3000.0));
		double val = 1.1;

		// list.forEach(new PriceUpdate());
		// list.forEach(Product::staticAccept);
		// list.forEach(Product::nonStaticAccept);

		// Consumer<Product> consumer = p -> p.setPrice(p.getPrice() * val);
		// list.forEach(consumer);

		list.forEach(p -> p.setPrice(p.getPrice() * val));

		list.forEach(System.out::println);
	}

}
