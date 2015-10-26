package algorithms.medium;

/**
 * didn't study further, directly copied solution from discuss, need to dive
 * deeper.
 */

class TrieNode {
	TrieNode[] children;
	boolean exist;

	// Initialize your data structure here.
	public TrieNode() {
		children = new TrieNode[26];
	}
}

public class _20150814_Trie {

	private TrieNode root;

	public _20150814_Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int ind = word.charAt(i) - 'a';
			if (p.children[ind] == null) {
				p.children[ind] = new TrieNode();
			}
			p = p.children[ind];
		}
		p.exist = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			int ind = word.charAt(i) - 'a';
			if (p.children[ind] == null) {
				return false;
			}
			p = p.children[ind];
		}
		return p.exist;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode p = root;
		for (int i = 0; i < prefix.length(); i++) {
			int ind = prefix.charAt(i) - 'a';
			if (p.children[ind] == null) {
				return false;
			}
			p = p.children[ind];
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("The end.");
	}

}
