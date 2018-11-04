import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Num15_ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> resultLists = new ArrayList<>();
		if(nums == null || nums.length < 3)
			return resultLists;
		HashSet<Integer> targetSet = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			if(targetSet.contains(nums[i])) {
				continue;
			} else {
				targetSet.add(nums[i]);	
			}
			List<List<Integer>> item = twoSum(nums, -nums[i], i + 1);
			if(item != null && !item.isEmpty()) {
				resultLists.addAll(item);
			}
		}
		
		return resultLists
				.stream()
				.distinct()
				.collect(Collectors.toList());
        
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int startIndex) {
    	if(nums == null || nums.length < 2) {
    		return null;
    	}
    	HashMap<Integer, Boolean> map = new HashMap<>();
    	List<List<Integer>> resultLists = new ArrayList<>();
    	for(int i = startIndex; i < nums.length; i++) {
    		int pattern = target - nums[i];
    		if(map.containsKey(pattern) && !map.get(pattern)) {
    			List<Integer> list = new ArrayList<>();
    			list.add(-target);
    			list.add(nums[i]);
    			list.add(pattern);
    			list.sort(null);
    			resultLists.add(list);
    			map.put(nums[i], true);
    		} else if(!map.containsKey(pattern)){
    			map.put(nums[i], false);
    		}
    	}
    	return resultLists;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		List<List<Integer>> result = threeSum(nums);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}
}
