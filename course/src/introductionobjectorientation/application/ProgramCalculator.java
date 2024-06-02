package introductionobjectorientation.application;

import java.util.Scanner;

import introductionobjectorientation.util.Calculator;

public class ProgramCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius: ");
		double radius = sc.nextDouble();
		
		double circumference = Calculator.circumference(radius);
		double volume = Calculator.volume(radius);
		
		System.out.println(circumference);
		System.out.println(volume);
		
		sc.close();
	}

}
