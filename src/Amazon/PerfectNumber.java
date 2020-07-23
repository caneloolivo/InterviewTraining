package Amazon;


public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		int divisor = 1;
		int sum = 0;
		while(divisor * divisor <= num) {
			if(num % divisor == 0) {
				sum+= divisor;
			}
			divisor ++;
		}
        return sum == num;
    }
	
	public static void main(String[] args) {
		PerfectNumber solution = new PerfectNumber();
		int num = 28;
		boolean result = solution.checkPerfectNumber(num);
		System.out.println("El resultado es" + result);
	}
}
