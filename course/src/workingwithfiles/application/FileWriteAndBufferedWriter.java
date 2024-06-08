package workingwithfiles.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteAndBufferedWriter {

	public static void main(String[] args) {
		String[] lines = new String[] { "Hello", "Hi", "Bye!" };
		String path = "C:\\Users\\W11\\Documents\\test.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
