package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		paragraph += ".";
		Set<String> bannedWord = new HashSet<>();
		HashMap<String, Integer> counter = new HashMap<String, Integer>();
		for(String word : banned)
			bannedWord.add(word);
		
		int maxFreq = 0;
		String result = "";
		StringBuilder tmpWord = new StringBuilder();		
		for(char c: paragraph.toCharArray()) {			
			if(Character.isLetter(c))
				tmpWord.append(Character.toLowerCase(c));
			else if(tmpWord.length() > 0) {
				String word = tmpWord.toString();
				if(!bannedWord.contains(word)) {
					counter.put(word, counter.getOrDefault(word, 0) +1);
					int count = counter.get(word); 
					if(count > maxFreq) {
						maxFreq = count;
						result = word.toString();
					}
				}
				tmpWord.setLength(0);
			}
		}		
        return result;
    }
	
	public static void main(String [] args) {
		MostCommonWord solution = new MostCommonWord();
		String paragraph = "Bob";
		String[] banned = {};
		String result = solution.mostCommonWord(paragraph, banned);
		System.out.println("La palabta más comun es " + result);
	}
}
