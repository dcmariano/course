package inheritancepolymorphism.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inheritancepolymorphism.entities.ImportedProduct;
import inheritancepolymorphism.entities.Product;
import inheritancepolymorphism.entities.UsedProduct;

public class MainProduct {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();

		List<Product> product = new ArrayList<>();

		for (int i = 0; i < numberProducts; i++) {

			System.out.println("\nProdutct #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (type == 'i') {

				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customFee));
			} else if (type == 'u') {

				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String manufactureDate = sc.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				try {
					product.add(new UsedProduct(name, price, sdf.parse(manufactureDate)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {

				product.add(new Product(name, price));
			}
		}
		System.out.println("\nPRICE TAGS:");
		for (Product i : product) {
			System.out.println(i.priceTag());
		}
		sc.close();
	}

}
