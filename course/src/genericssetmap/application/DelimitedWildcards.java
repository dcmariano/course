package genericssetmap.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimitedWildcards {

	public static void main(String[] args) {

		List<Integer> listInt = Arrays.asList(15, 23, 11, 85, 29);
		List<Double> listDbl = Arrays.asList(45.3, 92.9, 13.2, 20.152);
		List<Object> listObj = new ArrayList<>();

		copy(listInt, listObj);
		printList(listObj);
		copy(listDbl, listObj);
		printList(listObj);

	}

	private static void copy(List<? extends Number> listNumber, List<Object> listObj) {
		for (Number n : listNumber) {
			listObj.add(n);
		}
	}

	private static void printList(List<?> list) {
		for (Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
}
