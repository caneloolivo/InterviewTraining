package Amazon;

public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
        return Math.addExact(a, b);
    }
	
	public int getSum2(int a, int b) {
		if (a==0)
			return b;
		
		if(b==0)
			return a;
		
		while(b!=0) {
			int carry = (a & b)<<1;
			a = a ^ b;
			b = carry;
		}
		return a;
	}
	
	public static void main(String[] args) {
		SumOfTwoIntegers solution = new SumOfTwoIntegers();
		int a = 1;
		int b = 2;
		int result = solution.getSum2(a, b);
		System.out.println("El resultado de la suma es "+ result);
	}
}
