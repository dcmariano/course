package lambdaexpressions.entities;

import java.util.Objects;

public class Product {

	private String name;
	private Double price;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + ", price $" + String.format("%.2f", price);

	}

	// @Override
	public int compareTo(Product other) {
		return name.compareTo(other.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() <= 1500;
	}

	public boolean nonStaticProductPredicate() {
		return price <= 1500;
	}

	public static void staticAccept(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}

	public void nonStaticAccept() {
		price = price * 1.1;
	}

	public static String staticUpperCaseName(Product p) {
		return p.getName().toUpperCase();
	}

	public String nonStaticUpperCaseName() {
		return name.toUpperCase();
	}
}