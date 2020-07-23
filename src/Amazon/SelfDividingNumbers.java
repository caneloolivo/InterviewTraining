package Amazon;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = left; i<=right; i++ ) {
        	if(selfDividing(i))
        		result.add(i);
        }
        return result;
    }
	
	public boolean selfDividing(int value) {
		int target = value;
		while(value > 0) {
			int tmp = value %10;
			if(tmp == 0 || (target % tmp != 0))
				return false;
			value /= 10;
		}
		return true;
	}
	
	public static void main(String args[]) {
		SelfDividingNumbers solution = new SelfDividingNumbers();
		int left = 1;
		int right = 22;
		List<Integer> result = solution.selfDividingNumbers(left, right);
		System.out.println(String.valueOf(result));
	}
}
