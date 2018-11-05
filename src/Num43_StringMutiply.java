
public class Num43_StringMutiply {
	
    public static String multiply(String num1, String num2) {
    	if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
    	int length1 = num1.length();
    	int length2 = num2.length();
    	int resultArray[] = new int[length1 + length2];
    	int k = 0;
    	for(int i = length1 - 1; i >= 0; i--) {
    		k = length1 - 1 - i;
    		for(int j = length2 - 1; j >= 0; j--) {
    			resultArray[k] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
    			resultArray[k+1] += (resultArray[k] / 10);
    			resultArray[k] %= 10;
    			k++;
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = resultArray.length - 1; i >= 0; i--) {
    		if(!(sb.length() == 0 && resultArray[i] == 0)) {
    			sb.append(resultArray[i]);
    		}
    	}
		return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("999", "999"));
	}

}
