package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Day27_Java_consecutive_occurance {

	public static void main(String[] args) {

		String x = "Amazon is a great company ass it haaaas atooooZzz";
		String[] y = x.split(" ");
		List<Integer> sorter = new ArrayList<Integer>();
		List<Character> ls_char = new ArrayList<Character>();
		List<Integer> ls_int = new ArrayList<Integer>();
		Map<Character, Integer> mp_final = new TreeMap<Character, Integer>();
		int cnt = 0;
		int count = 0;
		Map<Character, Integer> mp = new TreeMap<Character, Integer>();

		for (int i = 0; i <= y.length - 1; i++) {
			for (int n = 0; n < y[i].length(); n++) {
				for (int j = 0; j < y[i].length(); j++) {
					// System.out.println("y[i].charAt(" + n + ")" +
					// y[i].charAt(n) + "------" + "y[i].charAt(" + j + ")"+
					// y[i].charAt(j));
					if (y[i].charAt(n) == y[i].charAt(j)) {
						cnt++;
					}
				}
				if (cnt > 1) {
					// System.out.println("y[i].charAt(" + n + ") : " +
					// y[i].charAt(n)+" Count is :"+cnt);
					mp.put(y[i].charAt(n), cnt);

				}
				cnt = 0;
			}
		}

		for (Entry<Character, Integer> m : mp.entrySet()) {
			ls_char.add(m.getKey());
		}

		for (int i = 0; i < ls_char.size(); i++) {
			for (int j = 0; j < x.length(); j++) {
				if (ls_char.get(i) == x.charAt(j)) {
					//System.out.println(ls_char.get(i) + "  is occured in index :" + j);
					ls_int.add(j);
				}
			}

			for (int k = 0; k < ls_int.size() - 1; k++) {
				if (ls_int.get(k + 1) - ls_int.get(k) == 1) {
					count++;
				}
			}
			mp_final.put(ls_char.get(i), count + 1);
			//System.out.println(count);
			count = 0;
			ls_int.clear();
		}
		for (Entry<Character, Integer> fin : mp_final.entrySet()) {
			sorter.add(fin.getValue());
		}
		Collections.sort(sorter);

		for (Entry<Character, Integer> fin : mp_final.entrySet()) {
			if (fin.getValue() == sorter.get(sorter.size() - 1)) {
				System.out.println(fin.getKey() + " Occured Consecutively : " + fin.getValue() + " times");
			}
		}

		// System.out.println(mp.get(sorter.get(sorter.size()-1)) +" Occured
		// "+sorter.get(sorter.size()-1)+" times");
	}

}
