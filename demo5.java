package leetTest;

/**
 * Longest Palindromic Substring
 * 最长回文子串
 * @author xueshangling
 *  首先说下什么是回文串，就是正读反读都一样的字符串
 *  那么最长回文子串就是在一个字符串中的那个最长的回文子串
 *  
 *  Input: "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.

	Input: "cbbd"
	Output: "bb"
 */
public class demo5 {

	public static void main(String[] args) {
		
		String str = "babadada";
		System.out.println(longestPalindrome(str));
	}

	private static String longestPalindrome(String s){
		  int n = s.length();
		  String res = null;
		    
		  boolean[][] deep = new boolean[n][n];
		    
		  for (int i = n - 1; i >= 0; i--) {
		    for (int j = i; j < n; j++) {
		    	deep[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || deep[i + 1][j - 1]);
		            
		      if (deep[i][j] && (res == null || j - i + 1 > res.length())) {
		        res = s.substring(i, j + 1);
		      }
		    }
		  }
		    
		  return res;
	}
	
}
