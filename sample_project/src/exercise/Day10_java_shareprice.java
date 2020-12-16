package exercise;

public class Day10_java_shareprice {

	public static void main(String[] args) {
		int arr[] = { 7, 1, 5, 3, 6, 4, 1, 8, 10 };
		int buy_day = 5;
		int stock_price = arr[buy_day - 1];
		int temp = 0;
		int compare[] = new int[arr.length - (buy_day)];

		System.out.println("Stock Purchased on 		   : Day " + buy_day);
		System.out.println("Stock Price on that Day is         : $" + stock_price);

		for (int i = buy_day; i < arr.length; i++) {
			if (stock_price < arr[i]) {
				compare[temp] = arr[i];
				temp++;
			}
		}

		int temp1 = 0;
		for (int i = 0; i < compare.length; i++) {
			for (int j = i; j < compare.length; j++) {
				if (compare[i] > compare[j]) {
					temp1 = compare[i];
					compare[i] = compare[j];
					compare[j] = temp1;
				}
			}
		}

		int highest = compare[compare.length - 1];
		if (highest == 0) {
			System.out.println("Share price not yet increased till now");
		}
		int profit = 0;
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == highest) {
				System.out.println("User can sell the share on         : Day " + (i + 1));
				System.out.println("Highest Share price is 		   : $" + arr[i]);
				System.out.println();
				profit = arr[i] - stock_price;
				System.out.println("Profit in selling : $" + profit);
			}

		}

	}

}
