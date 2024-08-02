package genericssetmap.application;

import genericssetmap.entities.Client;

public class MainHashCodeAndEquals {

	public static void main(String[] args) {

		Client c1 = new Client("Davi", "davi@domain.com");
		Client c2 = new Client("Davi", "davi@domain.com");
		
		System.out.println("c1 hash code= " + c1.hashCode());
		System.out.println("c2 hash code= " + c1.hashCode());
		System.out.println(c1.hashCode() == c2.hashCode());
		System.out.println(c1.equals(c2));
		System.out.println(c1 == c2);
	}

}
