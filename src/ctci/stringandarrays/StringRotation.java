package ctci.stringandarrays;

public class StringRotation {
	
	public static boolean isSubstring(String s1, String s2) {
		return s1.indexOf(s2) != -1;
	}
	
	public static boolean isRotation(String s1, String s2) {
		return s1.length() == s2.length() && isSubstring(s1 + s1, s2);
	}
	
	public static void main(String[] args) {
		System.out.println(isRotation("abcdefghi", "fghiabcde"));
		System.out.println(isRotation("abcdesfghi", "fghisabcde"));
	}

}
