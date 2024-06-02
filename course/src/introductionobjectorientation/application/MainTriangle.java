package introductionobjectorientation.application;

import introductionobjectorientation.entities.Triangle;

public class MainTriangle {

	public static void main(String[] args) {

		Triangle x = new Triangle();
		Triangle y = new Triangle();
		
		x.a = 10;
		x.b = 15;
		x.c = 32;
		
		y.a = 20;
		y.b = 45;
		y.c = 12;

		System.out.println("The X triangle area is:: " + x.area());
		System.out.println("The Y triangle area is: " + y.area());
		
		
	}

}
