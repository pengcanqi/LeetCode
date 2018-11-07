
public class Num5_LongestPalindromeSolvedByManacher {
	
	public static char[] init(String s) {
		int n = s.length();
		char[] charArray = new char[2 * n + 3];
		charArray[0] = '$';
		charArray[1] = '#';
		for(int i = 0, j = 2; i < s.length(); i++) {
			charArray[j++] = s.charAt(i);
			charArray[j++] = '#';
		}
		charArray[charArray.length - 1] = '\0';
		return charArray;
	}
	
	public static String longestPalindrome(String s) {
		if(s == null || s.isEmpty() || s.length() == 1) {
			return s;
		}
        char[] charArray = init(s);
        int[] p = new int[charArray.length];
        int id = 0;
        int max = 0;
        for(int i = 1; i < charArray.length - 1; i++) {
        	if(i < max) {
            	p[i] = Math.min(p[2 * id - i], max - i);
        	} else {
				p[i] = 1;
			}
        	
        	while (charArray[i - p[i]] == charArray[i + p[i]]) {
				p[i]++;
			}
        	
        	if(max < p[i] + i) {
        		id = i;
        		max = p[i] + i;
        	}
        }
        int maxLength = 0;
        int index = 0;
        for(int i = 2; i < p.length - 1; i++) {
        	if(p[i] - 1 > maxLength) {
        		maxLength = p[i] - 1;
        		index = i;
        	}
        }
    	int sIndex = (index - 2) / 2;
    	int radius = maxLength / 2;
        if(index % 2 == 0) {
        	return s.substring(sIndex - radius, sIndex + radius + 1);
        } else {
			return s.substring(sIndex - radius + 1, sIndex + radius + 1);
		}
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("cabbad"));
	}

}
