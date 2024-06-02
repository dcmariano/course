package introductionobjectorientation.entities;

public class Student {
	public String name;
	public double firstQuarter;
	public double secondQuarter;
	public double thirdQuarter;

	public double totalPoint() {
		return firstQuarter + secondQuarter + thirdQuarter;
	}

	public String situation() {
		if (totalPoint() > 60) {
			return "Pass with " + String.format("%.2f", totalPoint()) + " points";
		} else {
			double point = 60 - totalPoint();
			return "Failed, your need to " + String.format("%.2f", point) + " points for pass";
		}
	}

	public String toString() {
		return "Name: " + name + "\n" 
				+ "First quarter: " + String.format("%.2f", firstQuarter) + "\n"
				+ "Second quarter: " + String.format("%.2f", secondQuarter) + "\n" 
				+ "Third quarter: " + String.format("%.2f", thirdQuarter) + "\n" 
				+ "Final grade: " + String.format("%.2f", totalPoint()) + "\n" 
				+ "Situation: " + situation();

	}

}
