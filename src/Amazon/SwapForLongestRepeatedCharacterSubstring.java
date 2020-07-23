package Amazon;

import java.util.HashMap;

public class SwapForLongestRepeatedCharacterSubstring {
	public int maxRepOpt1(String text) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: text.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
            max = Math.max(max, map.get(c));
        }
        return max;        
    }
}
