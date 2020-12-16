package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Day21_Java_letter_occurance {

	public static void main(String[] args) {

		String s = "Welcome to Testleaf";
		System.out.println("Input : "+s);
		char[] s_arr = s.toCharArray();
		Set<Character> s1 = new TreeSet<Character>();
		List<Integer> temp = new ArrayList<Integer>();
		Map<Character, Integer> mp1 = new HashMap<Character, Integer>();
		boolean flag = false;
		int n = 0, count = 0;

		for (Character arr : s_arr) {
			flag = Character.isWhitespace(s_arr[n]);
			if (flag == false) {
				s1.add(s_arr[n]);
			}
			n++;
		}

		List<Character> lst = new ArrayList<Character>(s1);
		n = 0;
		for (int i = 0; i < lst.size(); i++) {
			for (int j = 0; j < s_arr.length; j++) {
				if (lst.get(i) == s_arr[j]) {
					count++;
				}
			}
			System.out.println(lst.get(i) + "-----" + count);
			mp1.put(lst.get(i), count);
			temp.add(count);
			if (count > 1) {
				n = 0;
			} else {
				n++;
			}
			count = 0;
		}

		//System.out.println(n + "  list " + lst.size());
		Collections.sort(temp);

		int max = temp.get(temp.size() - 2);
		System.out.println("Maximum Value : "+temp.get(temp.size()-1)+" and the second largest value is : "+max);
		if (n != lst.size()) {
			for (Map.Entry<Character, Integer> entry : mp1.entrySet()) {
				if (max == entry.getValue())
					System.out.println("Output : " + entry.getKey() + "  Occurs  " + entry.getValue() + "  Times");
			}
		} else if (n == lst.size()) {
			System.out.println("Output : " + " ");
		}

	}

}
