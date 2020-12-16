package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Day25_Java_Palindrome {

	public static void main(String[] args) {
		String input = "google";
		String tmp = new String();
		int n = 0;
		List<String> input_lst = new ArrayList<String>();
		List<String> lst = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			input_lst.add(input.substring(i));
		}
		System.out.println(input_lst);
		
		for (int x = 0; x < input_lst.size(); x++) {
			n=0;
			for (int i = 0; i < input_lst.get(x).length(); i++) {
				n++;
				for (int j = 0; j < n; j++) {
					tmp = tmp + input_lst.get(x).charAt(j);
				}
				lst.add(tmp);				
				tmp = "";
			}
		}
		System.out.println(lst);
		input_lst.clear();
		
		for (int i = 0; i < lst.size(); i++) {
			for (int j = lst.get(i).length()-1; j >= 0; j--) {
				tmp = tmp +lst.get(i).charAt(j);
			}
			input_lst.add(tmp);
			tmp="";
		}
		System.out.println(input_lst);
		Set<String> st = new TreeSet<String>();
		
		for (int i = 0; i < lst.size(); i++) {
			if(lst.get(i).equalsIgnoreCase(input_lst.get(i))){
				st.add(lst.get(i));
			}			
		}
		System.out.println(st);
	}

}
