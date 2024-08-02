package genericssetmap.application;

import java.util.Map;
import java.util.TreeMap;

public class MainMap {

	public static void main(String[] args) {

		Map<String, String> cookies = new TreeMap<>();
		cookies.put("username", "Davi");
		cookies.put("phone", "11999999999");
		cookies.put("email", "davi@domain.com");

		printMap(cookies);

		cookies.remove("email");
		cookies.put("phone", "11999998888");
		System.out.println();

		System.out.println("Contains 'phone' key " + cookies.containsKey("phone"));
		System.out.println("Phone number: " + cookies.get("phone"));
		System.out.println("Email: " + cookies.get("email"));
		
		System.out.println();
		printMap(cookies);
	}

	public static <K, V> void printMap(Map<K, V> map) {
		if (map == null) {
			System.out.println("Map is null");
			return;
		}

		if (map.isEmpty()) {
			System.out.println("Map is empty");
			return;
		}

		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
