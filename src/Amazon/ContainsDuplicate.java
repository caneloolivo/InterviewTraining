package Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Arrays.parallelSort(nums);
		for(int i=0;i < nums.length-1; i++) {
			if(nums[i] == nums[i+1])
				return true;
		}
        return false;
    }
	
	public boolean containsDuplicate2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i< nums.length; i++) {
			if(map.containsKey(nums[i]))
				return true;
			map.put(nums[i], i);
		}
         return false;
	}
	
	public boolean containsDuplicate3(int[] nums) {
		Set<Integer> keys = new HashSet<Integer>();
		for(int i=0; i< nums.length; i++) {
			if(keys.contains(nums[i]))
				return true;
			keys.add(nums[i]);
		}
        return false;
    }
}
