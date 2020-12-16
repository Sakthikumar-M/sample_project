package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Joiner;

public class Day17_Java_LargeNo_logic2 {

	public static void main(String[] args) {

		int num[] = { 3,30,34,5,9 };
		List<String> lst = new ArrayList<String>();

		for (int i = 0; i < num.length; i++) {
			lst.add(Integer.toString(num[i]));
		}

		Collections.sort(lst);
		Collections.reverse(lst);
		
		String result = Joiner.on("").join(lst);
		System.out.println(result);
		

	}

}
