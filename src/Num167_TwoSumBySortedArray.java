
public class Num167_TwoSumBySortedArray {

	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		int length = numbers.length;
		int j = 0;
		int k = length - 1;
		while (j != k && numbers[j] + numbers[k] != target) {
			while (j != k && numbers[j] + numbers[k] > target) {
				k--;
			}
			while (j != k && numbers[j] + numbers[k] < target) {
				j++;
			}
		}
		return j == k ? null : new int[] { j + 1, k + 1 };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] { 2, 7, 11, 15 };
		int[] result = twoSum(input, 9);
		if (result != null) {
			for (int i : result) {
				System.out.println(i);
			}
		}
	}

}
