
public class Num5_LongestPalindrome {
	
	public static String longestPalindrome(String s) {
		if(s == null || s.isEmpty() || s.length() == 1) {
			return s;
		}
        int n = s.length();
        //palidromeMatix[i][j] == true represents the s[i,j] is palindrome
        boolean[][] palidromeMatix = new boolean[n][n];
        for(int i = 0; i < n; i++) {
        	palidromeMatix[i][i] = true;
        }
        //按从左到右，自下到上填充矩阵
        for(int j = 1; j < n; j++) {
        	for(int i = j - 1; i >= 0; i--) {
        		boolean equals = s.charAt(i) == s.charAt(j);
        		if(equals) {
        			if(j - i == 1 || palidromeMatix[i + 1][j - 1]) {
        				palidromeMatix[i][j] = true;
        			}
        		}
        	}
        }
        int max = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        for(int j = 0; j < n; j++) {
        	for(int i = j; i >= 0; i--) {
        		if(j - i > max && palidromeMatix[i][j]) {
        			max = j - i;
        			startIndex = i;
        			endIndex = j;
        		}
        	}
        }
		return s.substring(startIndex, endIndex + 1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("cbbd"));
	}

}
