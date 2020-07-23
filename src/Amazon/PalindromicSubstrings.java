package Amazon;

public class PalindromicSubstrings {
	int count;
	public int countSubstrings(String s) {
        count = 0;
        for(int i =0; i < s.length(); i++) {
        	isPalindrome(s, i, i); // odd length;
        	isPalindrome(s, i, i + 1); // even length
        }
        return count;
    }
	private void isPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() 
				&& s.charAt(left) == s.charAt(right)) {
			count++; 
			left--;
			right++; 
		} 
	} 
	public static void main(String[] args) {
		PalindromicSubstrings solution = new PalindromicSubstrings();
		String s = "aaa";
		int result = solution.countSubstrings(s);
		System.out.println("The number of palindroms are "+ result);
	}
}
