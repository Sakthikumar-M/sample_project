package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Joiner;

public class Day15_java_anagram {
	static List<Character> lst = new ArrayList<Character>();

	public static void main(String[] args) {
		String s = "Stressed";
		String t = "Desserts";

		System.out.println("String S : "+ s);
		System.out.println("String T : "+ t);
		System.out.println();
		
		String ans1 = sorter(s, lst);
		String ans2 = sorter(t, lst);
		
		boolean flag = ans1.equals(ans2);

		if (flag==true) {
			System.out.println(flag);
			System.out.println("String T: "+ t + " is AN ANAGRAM of String S: "+s);
		} else {
			System.out.println(flag);
			System.out.println("String T:"+ t + " is NOT AN ANAGRAM of String S:"+s);
		}
	}

	public static String sorter(String str, List<Character> lst) {
		// clear the List
		lst.clear();
		//Convert to Lower case
		String str1 = str.toLowerCase();
		//Convert to character array
		char[] arr = str1.toCharArray();
		//Insert the characters inside the character list
		for (Character ar : arr) {
			lst.add(ar);
		}
		//Sorting the List
		Collections.sort(lst);
		
		//Logic - 1 Approach using String Join class
		String ans = Joiner.on("").join(lst);
		
		//Logic - 2 Approach using String builder
		/*StringBuilder stb = new StringBuilder();
		for (Character ls : lst) {
			stb.append(ls);
		}
		String ans = stb.toString();*/

		return ans;
	}

}
