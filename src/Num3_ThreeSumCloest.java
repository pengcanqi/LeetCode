import java.util.Arrays;

public class Num3_ThreeSumCloest {

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i+1;
			int k = nums.length - 1;
			while (j < k) {
				int temp = nums[j] + nums[k] + nums[i];
				if (temp == target) {
					return target;
				}
				int tempDiff = Math.abs(target - temp);
				if (tempDiff < diff) {
					result = temp;
					diff = tempDiff;
				}
				if (temp > target) {
					k--;
				} else if (temp < target) {
					j++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { -1, 2, 1, -4 };
		System.out.println(threeSumClosest(nums, 1));
	}

}
