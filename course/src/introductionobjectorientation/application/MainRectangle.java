package introductionobjectorientation.application;

import java.util.Scanner;

import introductionobjectorientation.entities.Rectangle;

public class MainRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Rectangle rectangle = new Rectangle();

		System.out.println("Enter the width of the rectangle");
		rectangle.width = sc.nextDouble();
		System.out.println("Enter the height of the rectangle");
		rectangle.heigth = sc.nextDouble();
		System.out.println();

		System.out.println(rectangle);

		sc.close();

	}

}
