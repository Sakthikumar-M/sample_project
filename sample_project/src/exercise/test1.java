package exercise;

import java.util.ArrayList;
import java.util.List;

public class test1 {

	public static void main(String[] args) {
		List<String> lst1 = new ArrayList<String>();

		lst1.add("Dune London");
		lst1.add("Hunkemoller");
		lst1.add("Satya Paul");
		lst1.add("Scotch Soda");
		lst1.add("Steve Madden");
		lst1.add("Superdry");

		char[] conv = null;
		int count = 0,n=0;
		int arr_int[] = new int[lst1.size()];
		for (int i = 0; i < lst1.size(); i++) {
			conv = lst1.get(i).toCharArray();
			for (int j = 0; j < conv.length; j++) {
				boolean flag = Character.isLowerCase(conv[j]);
				if (flag == true) {
					count++;
				}
			}
			arr_int[n] = count;
			n++;
			count = 0;
		}
		int temp=0;
		int arr_unsorted[] = new int [arr_int.length];
		for (int i : arr_unsorted) {
			arr_unsorted[temp] = arr_int[temp];
			temp++;			
		}
		temp=0;
		for (int i = 0; i < arr_int.length; i++) {
			for (int j = i; j < arr_int.length; j++) {
				if(arr_int[i]>arr_int[j]){
					temp = arr_int[i];
					arr_int[i] = arr_int[j];
					arr_int[j] = temp;
				}
			}
		}
		int max =arr_int[arr_int.length-1];
		
		int x=0;
		
		for (int i = 0; i < arr_unsorted.length; i++) {
			if(arr_unsorted[i]==max){
				System.out.println(lst1.get(i));
			}
		}
		
		

	}

}
