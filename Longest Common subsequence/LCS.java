

//useing recurcive approch

public class LCS {
	public static void main(String args[]) {
		String text1 = "abcde";
		String text2 = "abe";

		int ans = longestsommonsubsequnce(text1, text2);
		System.out.println(ans);
	}

	public static int longestsommonsubsequnce(String text1, String text2) {
		// TODO Auto-generated method stub
		return recurcive(text1, text2, 0, 0);
	}

	static int recurcive(String text1, String text2, int i, int j) {
		// TODO Auto-generated method stub

		if (i > text1.length() - 1 || j > text2.length() - 1)
			return 0;

		if (text1.charAt(i) == text2.charAt(j)) {
			return 1 + recurcive(text1, text2, i + 1, j + 1);
		} else {
			return Math.max(recurcive(text1, text2, i + 1, j), recurcive(text1, text2, i, j + 1));

		}
	}
}
