package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Joiner;

public class Day19_Java_Find_Anagram {

	public static void main(String[] args) {
		// abab
		String s = "cbaebabacd";
		char[] s_arr = s.toCharArray();
		String p = "abc";
		char[] p_arr = p.toCharArray();
		char[] temp = new char[p_arr.length];

		int n = 0, l = 0;

		try {
			for (int i = 0; i < s_arr.length; i++) {
				n = i;
				for (int j = 0; j < p_arr.length; j++) {
					temp[l] = (s_arr[n++]);
					l++;
				}
				verify_anagram(p_arr, temp, n);
				l = 0;
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Verification Completed");
		}
	}

	public static void verify_anagram(char[] p_arr, char[] temp, int n) {
		boolean flag = false;
		String p_value, temp_value;

		p_value = sorter(p_arr);
		temp_value = sorter(temp);

		flag = p_value.equals(temp_value);

		StringBuilder str = new StringBuilder();
		for (char c : temp) {
			str.append(c);
		}
		String Temp = str.toString();

		if (flag == true) {

			System.out.println(Temp + "  index of :" + (n - (p_arr.length)) + " to " + (n - 1)
					+ " is forming the ANAGRAM for " + p_value);
		}
	}

	private static String sorter(char[] arr) {
		List<Character> lst = new ArrayList<Character>();
		String value;
		for (Character ar1 : arr) {
			lst.add(ar1);
		}
		Collections.sort(lst);
		value = Joiner.on("").join(lst);
		lst.clear();
		return value;
	}

}
