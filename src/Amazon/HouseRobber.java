package Amazon;

public class HouseRobber {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) 
			return 0;
		if(nums.length == 1)
			return nums[0];
		int n = nums.length;
		int[] houses = new int[n];
		houses[0] = nums[0];
		houses[1]= Math.max(nums[0], nums[1]);
		for(int i = 2; i < n; i++) {
			houses[i] = Math.max(nums[i] + houses[i-2] , houses[i-1]);
		}
		return houses[n-1];
    }
	
	public static void main(String[] args) {
		HouseRobber solution = new HouseRobber();
		int[] nums = {2,7,9,3,1};
		int result = solution.rob(nums);
		System.out.println("The ammount is "+ result);
	}
}
