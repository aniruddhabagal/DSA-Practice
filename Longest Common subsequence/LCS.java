/*Given two strings text1 and text2, return the length of their longest common subsequence.
	If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some 
characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.
*/

/*
Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
	*/

//useing recurcive approch

public class LCS {
//main class
	public static void main(String args[]) {
		String text1 = "abcde";
		String text2 = "abe";

		int ans = longestsommonsubsequnce(text1, text2);
		System.out.println(ans);
	}

	//Logest common subsequnce class
	public static int longestsommonsubsequnce(String text1, String text2) {
		//call the recurcive method ( string 1, string 2, variable i, variable j )
		return recurcive(text1, text2, 0, 0);
	}

	static int recurcive(String text1, String text2, int i, int j) {
		//if any one string is extended it's length so return 0
		if (i > text1.length() - 1 || j > text2.length() - 1)
			return 0;

		//if there is common characters in both string then return 1 + call recurcive method again for both strings
		if (text1.charAt(i) == text2.charAt(j)) {
			return 1 + recurcive(text1, text2, i + 1, j + 1);
		} 
		else 
		{
			// call recurcive method for both.
			//for first string 1 and second string 2 and get maximum from that for best possible result
			return Math.max(recurcive(text1, text2, i + 1, j), recurcive(text1, text2, i, j + 1));
		}
	}
}
