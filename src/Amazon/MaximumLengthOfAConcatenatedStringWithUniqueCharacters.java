package Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	int maxLength;
	public int maxLength(List<String> arr) {
		maxLength = 0;
		helper(new HashSet<Character>(), arr, 0);
		return maxLength;
    }
	
	public void helper(Set<Character> set, List<String> arr, int index) {
		if(index == arr.size())
			return;
		char[] s = arr.get(index).toCharArray();
		boolean isUnique = true;
		Set<Character> characters = new HashSet<Character>();
		for(char c: s) {
			if(characters.contains(c) || set.contains(characters)) {
				isUnique = false;
				break;
			}
			characters.add(c);
		}
		
		helper(set, arr, index +1);
		if(isUnique) {
			maxLength = Math.max(maxLength, set.size() + s.length);		
			set.addAll(characters);
			helper(set, arr, index + 1);
			set.removeAll(characters);
		}
	}
}
