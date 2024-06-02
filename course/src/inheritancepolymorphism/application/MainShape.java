package inheritancepolymorphism.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inheritancepolymorphism.entities.Circle;
import inheritancepolymorphism.entities.Rectangle;
import inheritancepolymorphism.entities.Shape;
import inheritancepolymorphism.entities.enums.Color;

public class MainShape {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the numbers of shapes: ");
		int numberShapes = sc.nextInt();

		List<Shape> shapes = new ArrayList<>();

		for (int i = 0; i < numberShapes; i++) {
			System.out.println("\nShape #" + (i + 1) + " data:");
			System.out.print("Rectangle or circle (r/c)? ");
			char decision = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Color (BLACK/RED/BLUE): ");
			Color color = Color.valueOf(sc.next());
			if (decision == 'r') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				shapes.add(new Rectangle(color, width, height));
			} else {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				shapes.add(new Circle(color, radius));
			}
		}

		System.out.println("\nSHAPE AREA:");
		for (Shape i : shapes) {
			System.out.println(String.format("%.2f", i.area()));
		}

		sc.close();
	}

}
