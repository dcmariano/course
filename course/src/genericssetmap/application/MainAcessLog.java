package genericssetmap.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import genericssetmap.entities.LogAcess;

public class MainAcessLog {

	public static void main(String[] args) {

		try (BufferedReader bf = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {
			Set<LogAcess> userAccess = new HashSet<>();
			String line = bf.readLine();
			while (line != null) {
				String[] fields = line.split(", ");
				String name = fields[0];
				OffsetDateTime moment = OffsetDateTime.parse(fields[1]);
				line = bf.readLine();
				userAccess.add(new LogAcess(name, moment));
			}
			System.out.println("Total users: " + userAccess.size());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}