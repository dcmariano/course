package workingwithfiles.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workingwithfiles.application.entities.Product;

public class MainProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a file path: ");
		String strSourceFile = sc.nextLine();
		File sourceFile = new File(strSourceFile);
		String strTargetFile = sourceFile.getParent() + "/out/" + sourceFile.getName();
		new File(sourceFile.getParent() + "/out").mkdir();
		List<Product> products = new ArrayList<>();

		try (BufferedReader bf = new BufferedReader(new FileReader(strSourceFile))) {
			String strLine = bf.readLine();
			while (strLine != null) {
				System.out.println(strLine);
				String[] strFields = strLine.split(",");
				String strName = strFields[0];
				Double dblPrice = Double.parseDouble(strFields[1]);
				int intQuantity = Integer.parseInt(strFields[2]);
				products.add(new Product(strName, dblPrice, intQuantity));
				strLine = bf.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strTargetFile))) {
				for (Product product : products) {
					bw.write(product.toString());
					bw.newLine();
				}
				System.out.println("success creating file");
			} catch (IOException e) {
				System.err.println("Error :" + e.getMessage());
			}

		} catch (IOException e) {
			System.err.println("Error :" + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
