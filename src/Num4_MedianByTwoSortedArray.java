import java.util.Arrays;

public class Num4_MedianByTwoSortedArray {
	
	public static boolean isNullOrEmpty(int[] array) {
		return array == null || array.length == 0 ? true : false;
	}
	
	public static double getAvg(double a, double b) {
		return (a + b) / 2;
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		boolean flag = (n1 + n2) % 2 == 0 ? true : false;
		int k = flag ? (n1 + n2) / 2 : (n1 + n2) / 2 + 1;
		
		while(k != 1) {
			if(isNullOrEmpty(nums1) || isNullOrEmpty(nums2)) {
				break;
			}
			if(k / 2 >= nums1.length) {
				if(nums1[nums1.length - 1] < nums2[k / 2 - 1]) {
					k -= nums1.length;
					nums1 = null;
				} else {
					nums2 = Arrays.copyOfRange(nums2, k / 2, nums2.length);
					k -= k/2;
				}
			} else if (k / 2 >= nums2.length) {
				if(nums2[nums2.length - 1] < nums1[k / 2 - 1]) {
					k -= nums2.length; 
					nums2 = null;
				} else {
					nums1 = Arrays.copyOfRange(nums1, k / 2, nums1.length);
					k -= k/2;
				}
			} else {
				if(nums1[k / 2 - 1] <= nums2[k / 2 -1]) {
					nums1 = Arrays.copyOfRange(nums1, k / 2, nums1.length);
				} else {
					nums2 = Arrays.copyOfRange(nums2, k / 2, nums2.length);
				}
				k -= k/2;
			}
		}
		if(!flag) {
			if(isNullOrEmpty(nums1)) {
				return nums2[k - 1];
			} else if (isNullOrEmpty(nums2)) {
				return nums1[k - 1];
			} else {
				return Math.min(nums1[0], nums2[0]);
			}
		} else {
			if(isNullOrEmpty(nums1)) {
				return getAvg(nums2[k - 1], nums2[k]);
			} else if (isNullOrEmpty(nums2)) {
				return getAvg(nums1[k - 1], nums1[k]);
			} else {
				if(nums1.length > 1 && nums2.length > 1) {
					if(nums1[0] >= nums2[1]) {
						return getAvg(nums2[0], nums2[1]);
					} else if (nums1[1] <= nums2[0]) {
						return getAvg(nums1[0], nums1[1]);
					} else {
						return (Math.min(nums1[0], nums1[1]) 
								+ Math.min(nums2[0], nums2[0])) 
								/ 2.0;
					}
				}
				if(nums1.length == 1 && nums2.length == 1) {
					return getAvg(nums1[0], nums2[0]);
				}
				if(nums1.length <= 1) {
					return (nums1[0] + nums2[0] + nums2[1] 
							- Math.max(nums2[1], Math.max(nums1[0], nums2[0]))) / 2.0;
				} else {
					return (nums2[0] + nums1[0] + nums1[1] 
							- Math.max(nums1[1], Math.max(nums1[0], nums2[0]))) / 2.0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMedianSortedArrays(new int[] {1}, new int[] {1}));
	}

}
