package composition.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import composition.entities.Client;
import composition.entities.Order;
import composition.entities.OrderItem;
import composition.entities.Product;
import composition.entities.enums.OrderStatus;

public class MainOrder {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date: ");
		Date birthDate = sdf.parse(sc.nextLine());
		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());

		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		
		System.out.println();

		Order order = new Order(new Date(), status, client);
		
		for (int i = 0; i < items; i++) {
			System.out.println("Enter #" + (i + 1) + " item data");
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();

			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();

			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();

			System.out.println();

			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}

		System.out.println("ORDER SUMMARY");
		System.out.println(order);

		sc.close();
	}

}
