package genericssetmap.application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainSet {
	public static void main(String[] args) {
		// HashSet
		System.out.println("HashSet");
		Set<String> hashSet = new HashSet<>();
		hashSet.add("TV");
		hashSet.add("Notebook");
		hashSet.add("Phone");
		hashSet.add("Tablet");
		hashSet.add("Smartwatch");
		hashSet.add("Camera");
		hashSet.add("Printer");
		hashSet.add("Monitor");
		hashSet.add("Keyboard");
		hashSet.add("Mouse");

		System.out.println(hashSet.contains("Phone"));
		hashSet.remove("Notebook");
		hashSet.removeIf(x -> x.length() == 2);

		for (String s : hashSet) {
			System.out.print(s + " ");
		}
		System.out.println();

		// TreeSet
		System.out.println("TreeSet");
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("TV");
		treeSet.add("Notebook");
		treeSet.add("Phone");
		treeSet.add("Tablet");
		treeSet.add("Smartwatch");
		treeSet.add("Camera");
		treeSet.add("Printer");
		treeSet.add("Monitor");
		treeSet.add("Keyboard");
		treeSet.add("Mouse");

		System.out.println(treeSet.contains("Phone"));
		treeSet.remove("Notebook");
		treeSet.removeIf(x -> x.length() == 2);

		for (String s : treeSet) {
			System.out.print(s + " ");
		}
		System.out.println();

		// LinkedHashSet
		System.out.println("LinkedHashSet");
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("TV");
		linkedHashSet.add("Notebook");
		linkedHashSet.add("Phone");
		linkedHashSet.add("Tablet");
		linkedHashSet.add("Smartwatch");
		linkedHashSet.add("Camera");
		linkedHashSet.add("Printer");
		linkedHashSet.add("Monitor");
		linkedHashSet.add("Keyboard");
		linkedHashSet.add("Mouse");

		System.out.println(linkedHashSet.contains("Phone"));
		linkedHashSet.remove("Notebook");
		linkedHashSet.removeIf(x -> x.length() == 2);

		for (String s : linkedHashSet) {
			System.out.print(s + " ");
		}
		System.out.println();

		// Set operations
		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

		// union
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.print("Union: ");
		System.out.println(c);

		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.print("Intersection: ");
		System.out.println(d);

		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.print("Difference: ");
		System.out.println(e);
	}
}
