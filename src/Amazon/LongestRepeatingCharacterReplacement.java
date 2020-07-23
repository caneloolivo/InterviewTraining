package Amazon;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
        int left= 0, maxRepeat = 0, maxWindow = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int right = 0; right < s.length(); right++) {
        	char c = s.charAt(right);
        	
        	map.put(c, map.getOrDefault(c, 0) +1);
        	
        	maxRepeat = Math.max(maxRepeat, map.get(c));
        	
        	if(right- left + 1- maxRepeat > k) {
        		char remove = s.charAt(left);
        		map.put(remove, map.get(remove)-1);        		
        		left++;
        	}
        	maxWindow = Math.max(maxWindow, right - left +1);
        }
        return maxWindow;
    }
}
