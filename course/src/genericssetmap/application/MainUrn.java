package genericssetmap.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainUrn {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\in.txt"))) {
			Map<String, Integer> votes = new HashMap<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(", ");
				String candidate = fields[0];
				int cont = Integer.parseInt(fields[1]);
				line = br.readLine();

				if (votes.containsKey(candidate)) {
					votes.put(candidate, votes.get(candidate) + cont);
					continue;
				}
				votes.put(candidate, cont);
			}
			System.out.println("Counting the ballots");
			for (Map.Entry<String, Integer> entry : votes.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

}
