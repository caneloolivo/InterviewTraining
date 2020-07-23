package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupCategories {
	static class PairString{
		String first;
		String second;
		public PairString() {}
		public PairString(String first, String second) {
			this.first = first;
			this.second = second;
		}
	}
		
	public List<String> category(List<PairString> categories){
		HashMap<String, List<String>> map = new HashMap<>();
		String longestGroup = "group1";
		String lastGroup = "group1";
		List<String> tmpCategories = Arrays.asList(categories.get(0).first, categories.get(0).second);
		map.put(lastGroup, tmpCategories);
		int groupNumber = 2;		
		for(int i = 1 ; i < categories.size(); i ++) {
			List<String> lastCategories = new ArrayList<String>(map.get(lastGroup));
			if(lastCategories.contains(categories.get(i).first)) {
				lastCategories.add(categories.get(i).second);
				map.put(lastGroup, lastCategories);
				if(map.get(longestGroup).size()< lastCategories.size() && 
					!longestGroup.equals(lastGroup)) {
					longestGroup = lastGroup;
				}
			}
			else {
				String groupName = "group" + groupNumber;
				groupNumber++;
				tmpCategories = Arrays.asList(categories.get(i).first, categories.get(i).second);
				map.put(groupName, tmpCategories);
				lastGroup = groupName;
			}
		}
		return map.get(longestGroup);
	}				
	
	public static void main(String[] args) {
		GroupCategories solution = new GroupCategories();
		List<PairString> categories = new ArrayList<>();
		categories.add(new PairString("Item1","Item2"));
		categories.add(new PairString("Item3","Item4"));
		categories.add(new PairString("Item4","Item5"));
		List<String> result = solution.category(categories);
		System.out.println("La cagetorie más larga es "+ String.valueOf(result));
	}
}
