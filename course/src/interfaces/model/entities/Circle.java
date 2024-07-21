package interfaces.model.entities;

import interfaces.model.enums.Color;

public class Circle extends AbstractShape {

	private Double radius;

	public Circle() {
		super();
	}

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	@Override
	public final double area() {
		return Math.PI * radius * radius;
	}

}
