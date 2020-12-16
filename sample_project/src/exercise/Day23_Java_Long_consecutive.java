package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Day23_Java_Long_consecutive {

	public static void main(String[] args) {

		int arr[] = { 100, 4, 200, 1, 2, 3, 300, 6, 5, 7, 10 };
		int diff = 0, count = 0;
		List<Integer> lst = new ArrayList<Integer>();
		Set<Integer> st = new TreeSet<Integer>();
		List<Integer> lst2 = new ArrayList<Integer>();

		Arrays.sort(arr);

		for (int ar : arr) {
			System.out.print(ar + ",");
		}

		System.out.println();
		// System.out.println(arr.length);

		for (int i = 0; i < arr.length - 1; i++) {
			diff = arr[i + 1] - arr[i];
			// System.out.println(arr[i + 1] + " - " + arr[i] + " = " + diff);
			lst.add(diff);
			st.add(lst.get(i));
		}
		lst2.addAll(st);
		st.clear();

		for (int i = 0; i < lst2.size(); i++) {
			for (int j = 0; j < lst.size(); j++) {
				if (lst2.get(i).equals(lst.get(j))) {
					// System.out.println(lst2.get(i) + " compares " +
					// lst.get(j) + " = " + count);
					count++;
				}
			}
			st.add(count);
			count = 0;
		}

		lst2.clear();
		lst2.addAll(st);
		Collections.reverse(lst2);
		// System.out.println(lst2);

		System.out.println("Longest Consecutive count : " + (lst2.get(0) + 1));

	}

}
