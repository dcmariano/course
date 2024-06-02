package introductionobjectorientation.entities;

public class Rectangle {
	public double width;
	public double heigth;

	public double area() {
		return width * heigth;
	}

	public double perimeter() {
		return (2 * width) + (2 * heigth);
	}

	public double diagonal() {
		return Math.sqrt((heigth * heigth) + (width * width));
	}

	public String toString() {
		return "Width: " + String.format("%.2f", width) + "\n" 
				+ "Heigth: " + String.format("%.2f", heigth) + "\n" 
				+ "Area: " + String.format("%.2f", area()) + "\n" 
				+ "Perimeter: " + String.format("%.2f", perimeter())  + "\n"
				+ "Diagonal: " + String.format("%.2f", diagonal());
	}
}
