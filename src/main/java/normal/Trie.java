package normal;

/**
 * 【前缀树】实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * @author 胡鹏
 *
 */
public class Trie {
	
	private TrieNode root = new TrieNode();


	public void insert(String word) {
		char[] charArray = word.toCharArray();
		TrieNode currNode = root;
		for(char currChar : charArray) {
			if(!currNode.containsKey(currChar)) {
				currNode.put(currChar);
			}
			currNode = currNode.get(currChar);
		}
		currNode.setEnd();
	}
	
	public boolean search(String word) {
		TrieNode lastNode = getLastNode(word);
		return lastNode != null && lastNode.isEnd();
	}
	
	public boolean startsWith(String word) {
		return getLastNode(word) != null;
	}
	
	private TrieNode getLastNode(String word) {
		char[] charArray = word.toCharArray();
		TrieNode currNode = root;
		for(char currChar : charArray) {
			if(currNode.containsKey(currChar)) {
				currNode = currNode.get(currChar);
			} else {
				return null;
			}
		}
		return currNode;
	}
	
	
	public static class TrieNode {
		
		private static final int CAPACITY = 26;
		
		private TrieNode[] links;
		
		private boolean end;

		public TrieNode() {
			links = new TrieNode[CAPACITY];
		}
		
		public boolean containsKey(char key) {
			return links[key - 'a'] != null;
		}
		
		public void put(char key) {
			links[key - 'a'] = new TrieNode();
		}
		
		public TrieNode get(char key) {
			return links[key - 'a'];
		}

		public boolean isEnd() {
			return end;
		}

		public void setEnd() {
			this.end = true;
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
}
