package genericssetmap.application;

import java.util.Arrays;
import java.util.List;

public class WildcardTypes {

	public static void main(String[] args) {
		List<Integer> listInt = Arrays.asList(7, 23, 2, 10);
		printList(listInt);

		List<String> listStr = Arrays.asList("Orange", "Red", "Black", "White", "Blue");
		printList(listStr);
	}

	public static void printList(List<?> list) {
		for (Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}

}
