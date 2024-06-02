package memorybehaviorarrayslists.entities;

public class People {
	private String name;
	private int age;
	private double height;
	private char gender;
	
	public People (String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public People (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public People (double height, char gender) {
		this.height = height;
		this.gender = gender;
	}
	
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String toString() {
		return "People "
				+ "["
				+ "name=" + name 
				+ ", age=" + age 
				+ ", height=" + height 
				+ "]";
	}
	
}
