package interfaces.model.entities;

import interfaces.model.enums.Color;

public class Rectangle extends AbstractShape {

	private Double width;
	private Double height;
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	@Override
	public final double area() {
		return width * height;
	}
}