package Amazon;

public class ProductArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		int n = nums.length;
		for(int i = 1; i < n; i++) {
			result[i] = 1;		
		}
		int l = 1, r = 1;
		for (int i = 1; i < n; i++) {
			l *= nums[i -1];
			result [i] = l;
		}
		for(int i = n-2; i > -1; i--) {
			r *= nums[i +1];
			result[i] *= r;
		}
		 result[0] = r;
		return result;
    }
	public static void main(String args[]) {
		ProductArrayExceptSelf solution = new ProductArrayExceptSelf();
		int [] nums = {1, 2, 3, 4};
		int [] result = solution.productExceptSelf(nums);
		for(int num: result)
			System.out.print( num+" ");
	}
}
