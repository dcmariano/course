package introductionobjectorientation.entities;

public class Employee {
	public String name;
	public double glossSalary;
	public double tax;

	public double netSalary() {
		return glossSalary - tax;
	}

	public void increaseSalary(double percentage) {
		double increase = glossSalary / 100 * percentage;
		glossSalary += increase;
	}

	public String toString() {
		return "Name: " + name + "\n" 
				+ "Gloss Salary: " + String.format("%.2f", glossSalary) + "\n" 
				+ "Tax: "
				+ String.format("%.2f", tax) + "\n" 
				+ "NetSalary: " + String.format("%.2f", netSalary());
	}
}
