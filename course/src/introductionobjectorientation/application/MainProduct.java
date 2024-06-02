package introductionobjectorientation.application;

import java.util.Scanner;

import introductionobjectorientation.entities.Product;

public class MainProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Product product = new Product();

		System.out.println("Insert the product name");
		product.name = sc.nextLine();
		System.out.println("Insert the product price");
		product.price = sc.nextDouble();
		System.out.println("Insert the product quantity");
		product.quantity = sc.nextInt();

		System.out.println();
		System.out.println(product);
		System.out.println("Enter the number of products to be added in stock: ");
		product.addProducts(sc.nextInt());
		
		System.out.println("Enter the number of products to be removed in stock: ");
		product.removeProducts(sc.nextInt());
		
		System.out.println(product);


		sc.close();
	}

}
