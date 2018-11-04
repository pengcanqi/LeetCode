import java.util.HashMap;

public class Num1_TwoSum {
	
    public static int[] twoSum(int[] nums, int target) {
    	if(nums == null || nums.length < 2) {
    		return null;
    	}
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < nums.length; i++) {
    		int pattern = target - nums[i];
    		if(map.containsKey(pattern)) {
    			return new int[]{i, map.get(pattern)};
    		} else {
    			map.put(nums[i], i);
    		}
    	}
    	return null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
