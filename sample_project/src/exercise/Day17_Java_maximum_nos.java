package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day17_Java_maximum_nos {

	public static void main(String[] args) {
		// { 33, 80, 45, 5, 9, 7 }
		int num[] = { 33, 80, 45, 5, 9, 7 };
		int var = 0, n = 0, f_value = 0;
		List<Integer> lst = new ArrayList<Integer>();
		List<Integer> single = new ArrayList<Integer>();
		List<Integer> duel = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < num.length; i++) {
			lst.add(num[i]);
		}

		for (Integer ls : lst) {
			var = lst.get(n) % 10;
			if (var == lst.get(n)) {
				single.add(lst.get(n));
			} else {
				duel.add(lst.get(n));

			}
			n++;
		}

		Collections.sort(single);
		Collections.sort(duel);
		// Collections.sort(temp);

		Collections.reverse(single);
		Collections.reverse(duel);
		// Collections.reverse(temp);
		n = 0;
		for (Integer tp : duel) {
			f_value = duel.get(n) / 10;
			temp.add(f_value);
			n++;
		}

		System.out.println(single + "" + duel + "" + temp);

		for (int i = 0; i < single.size(); i++) {
			for (int j = 0; j < temp.size(); j++) {
				if (single.get(i) < temp.get(j))
					System.out.println(single.get(i) + " " + temp.get(j) + " " + duel.get(j));
				result.add(duel.get(j));
				
			}
			System.out.println(single.get(i));
			result.add(single.get(i));
		}
		
		System.out.println();
		// Collections.reverse(lst);
		System.out.println(result);

	}

}
