package Amazon;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
	class TrieNode{
		TrieNode[] children;
		boolean isEnd;
		public TrieNode() {
			children = new TrieNode[26];
		}
		public boolean containsKey(char c) {
			return children[c -'a'] != null;			
		}
		
		public TrieNode getValue(char c) {
			return children[c-'a'];
		}
		
		public void addValue(char c, TrieNode node) {
			children[c-'a'] = node;
		}
		
		public void setEnd() {
			isEnd = true;
		}
		public boolean isEnd() {
			return isEnd;
		}
	}
	TrieNode head = new TrieNode();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	TrieNode node = head;
    	for(String product: products) {
    		for(char c : product.toCharArray()) {
    			if(!node.containsKey(c))
    				node.addValue(c, new TrieNode());
    			node = node.getValue(c);
    		}
    		node.setEnd();
    	}
    	return result;
    }        
}
