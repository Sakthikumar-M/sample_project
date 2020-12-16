package exercise;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "rgb(40, 116, 240)";
		String[] ar1 = {"(",")",","};
		for (int i = 0; i < ar1.length; i++) {
			x = x.replace(ar1[i], " ");		
		}
		
		String[] ans = x.split(" ");
		int color = Integer.parseInt(ans[ans.length-1]);
		if(color>133 && color<250){
			System.out.println("The Text color is BLUE");
		}
		System.out.println(color);
	}

}
