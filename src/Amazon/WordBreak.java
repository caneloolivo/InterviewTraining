package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		return true;
    }
	public static void main(String[] args) {
		WordBreak solution = new WordBreak();
		String s = "catsandog"; 
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean result = solution.wordBreak(s, wordDict);
		System.out.println("El resultado es " + result);
	}
}
