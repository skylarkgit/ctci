package ctci.stringandarrays;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		int[] arr = {1, 6, 34, 6, 2, 43, 3};
		int[] arr2 = new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		
		System.out.println(Arrays.toString(arr2));
	}
}
