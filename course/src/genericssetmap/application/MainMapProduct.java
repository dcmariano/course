package genericssetmap.application;

import java.util.HashMap;
import java.util.Map;

import genericssetmap.entities.Product;

public class MainMapProduct {

	public static void main(String[] args) {

		Map<Product, Double> stock = new HashMap<>();

		Product p1 = new Product("TV", 1500.0);
		Product p2 = new Product("Phone", 2000.0);
		Product p3 = new Product("Notebook", 3000.0);

		stock.put(p1, 15000.0);
		stock.put(p2, 20000.0);
		stock.put(p3, 30000.0);

		Product p4 = new Product("TV", 1500.0);
		System.out.println("Stock contains TV? " + stock.containsKey(p4));
	}

}
