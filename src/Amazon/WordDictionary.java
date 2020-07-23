package Amazon;
import java.util.HashMap;

public class WordDictionary {
	class TrieNode{
		private HashMap<Character, TrieNode> children;
		private boolean isEnd;
		public TrieNode() {
			children = new HashMap<>();
		}
		public boolean containsKey(char c) {
			return this.children.containsKey(c);
		}
		
		public TrieNode get(char c) {
			return this.children.get(c);
		}
		
		public void put(char c, TrieNode node) {
			this.children.put(c, node);
		}
		public void setEnd() {
			this.isEnd = true;
		}
		public boolean isEnd() {
			return this.isEnd;
		}
	}
	
	TrieNode root;
	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode node = root;
        for(char c: word.toCharArray()) {
        	if(!node.containsKey(c))
        		node.put(c, new TrieNode());
        	node = node.get(c);
        }
        node.setEnd();
    }
    
    private boolean searchPrefix(String word, TrieNode node) {
    	for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
    		if(node.containsKey(c))
    			node = node.get(c);
            else{
                if(c == '.'){
                    for(char key: node.children.keySet()){
                        TrieNode child = node.get(key);
                        if(searchPrefix(word.substring(i+1), child))
                            return true;
                    }
                }
                return false;
            }
                
    	}
    	return node.isEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchPrefix(word, root);
    }
    
    public static void main(String[] args) {
    	WordDictionary search = new WordDictionary();
    	search.addWord("bad");
    	search.addWord("dad");
    	search.addWord("mad");
    	boolean contains = search.search(".ad");
    	System.out.println("Contiende " + contains);
    }
}
