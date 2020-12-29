package ctci.stringandarrays;

import ctci.util.Util;

public class ZeroMatrix {

	public static void doZero(int m, int n, int[][] a) {
		boolean ai[] = new boolean[m];
		boolean aj[] = new boolean[n];
		
		for ( int i=0; i<m ; i++ ) {
			for ( int j=0; j<n ; j++ ) {
				if (a[i][j] == 0) {
					ai[i] = true;
					aj[j] = true;
				}
			}
		}
		
		for ( int i=0; i<m ; i++ ) {
			for ( int j=0; j<n ; j++ ) {
				if (ai[i] || aj[j]) {
					a[i][j] = 0;
				}
			}
		}	
	}
	
	public static void main(String[] args) {
		int a[][] = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
		Util.print(a);
		System.out.println("20 years later");
		doZero(3, 3, a);
		Util.print(a);
	}
}
