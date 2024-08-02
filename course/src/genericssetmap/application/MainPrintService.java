package genericssetmap.application;

import java.util.Scanner;

import genericssetmap.services.PrintService;

public class MainPrintService {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrintService<Integer> ps = new PrintService<>();
		System.out.print("How many values? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print((i + 1) + " value: ");
			ps.addValue(sc.nextInt());
		}
		ps.print();
		sc.close();
	}

}
