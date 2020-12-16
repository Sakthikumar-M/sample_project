package exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Day29_Java_substring {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 11, 2, 13, -4, 12 };
		System.out.print("Given Input is : {");
		for (int i : arr) {
			System.out.print(i+" ");
		}		
		System.out.print("}");
		int n = 0, sum = 0,max=0;
		List<Integer> ls1 = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			n = i;
			for (int j = 0; j < 3; j++) {
				if(n==arr.length){
					break;
				}
				sum = sum + arr[n];
				//System.out.print(arr[n] + "\t");
				n++;
			}
			if(i==0){
				max=sum;
			}else if(i>0 && sum>max){
				max=sum;
			}
			//System.out.println(sum);
			sum = 0;
			//System.out.println();
		}
		
		//System.out.println(max);
		
		for (int i = 0; i < arr.length; i++) {
			n = i;
			ls1.clear();
			for (int j = 0; j < 3; j++) {
				if(n==arr.length){
					break;
				}
				sum = sum + arr[n];
				ls1.add(arr[n]);
				//System.out.print(arr[n] + "\t");
				n++;
			}
			//System.out.println(sum);
			if(sum==max){				
				System.out.println("Maximum sum value combination of sub array is "+ls1+"\nHighest sum value is : "+sum);				
			}
			sum = 0;
			System.out.println();			
		}
	}

}
