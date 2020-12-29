package ctci.util;

public class Util {
	public static void print(int a[][]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<a.length ;i++) {
			for (int j = 0; j<a[i].length;j++) {
				sb.append(a[i][j]);
				sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
