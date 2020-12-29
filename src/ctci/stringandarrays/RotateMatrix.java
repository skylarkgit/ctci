package ctci.stringandarrays;

import ctci.util.Util;

public class RotateMatrix {
	
	static void rotate(int a[][]) {
		int r = (int) Math.ceil(((double) a.length) / 2);
		for (int i = r; i > 0; i-=2) {
			rotateShell(a, i);
		}
	}
	
	static void rotateShell(int a[][], int r) {
		int offset = a.length - r*2 + ((r%2 == 0) ? 1 : 0);
		for (int i = 0; i < a.length-1; i++) {
			int temp = a[offset+0][offset+i];
			a[offset+0][offset+i] = a[offset+i][offset+r];
			a[offset+i][offset+r] = a[offset+r][offset+r-i];
			a[offset+r][offset+r-i] = a[offset+r-i][offset+0];
			a[offset+r-i][offset+0] = temp;
		}
	}
	
	public static void main(String[] args) {
//		int a[][] = {{1, 2}, {3, 4}};
		int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Util.print(a);
		System.out.println("20 years later");
		rotate(a);
		Util.print(a);
	}
}