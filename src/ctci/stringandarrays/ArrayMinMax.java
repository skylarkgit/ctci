package ctci.stringandarrays;

import java.util.Arrays;

public class ArrayMinMax {

	public static void main(String[] args) {
		int[] arr = {2, 7, 3, 6, 11, 5, 53, 2, 1};
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		
		System.out.println(String.format("Min = %d\nMax = %d", min, max));
	}
}
