import java.util.HashMap;

public class Num3_LongestSubString {
	
	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int maxLength = 0;
		int tempLength = 0;
		HashMap<Character, Integer> hashMap = new HashMap<>();//the index of character
		for(int i = 0; i < s.length(); i++) {
			Character current = s.charAt(i);
			if(!hashMap.containsKey(current) || (hashMap.get(current) < start)) {
				tempLength++;
				maxLength = tempLength > maxLength ? tempLength : maxLength;
			} else {
				tempLength = i - hashMap.get(current);
				start = hashMap.get(current) + 1;
			}
			hashMap.put(current, i);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcdbae"));
	}

}
