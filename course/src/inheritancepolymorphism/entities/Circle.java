package inheritancepolymorphism.entities;

import inheritancepolymorphism.entities.enums.Color;

public class Circle extends Shape {

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
