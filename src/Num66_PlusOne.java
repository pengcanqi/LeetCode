
public class Num66_PlusOne {
	
    public static int[] plusOne(int[] digits) {
        int carryBit = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
        	int sum = carryBit + digits[i];
        	carryBit = sum / 10;
        	digits[i] = sum % 10;
        	if(carryBit == 0) {
        		return digits;
        	}
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for(int i = 1; i < result.length; i++) {
        	result[i] = 0;
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1, 2, 3};
		input = plusOne(input);
		for (int i : input) {
			System.out.println(i);
		}
	}

}
