package other;

import util.TrieNode;


//class TrieNode {
//
//    public TrieNode[] children;
//    public boolean hasWord;
//    
//    public TrieNode() {
//         children = new TrieNode[26];
//         hasWord = false;
//    }
//}

public class Trie {

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.insert("lintcode");
		System.out.println(trie.search("lint")); 
		System.out.println(trie.startsWith("lint"));
	}
	
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a']==null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.hasWord=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a']!=null){
                node = node.children[c-'a'];
            }else{
                return false;
            }
        }
        return node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c-'a']!=null){
                node = node.children[c-'a'];
            }else{
                return false;
            }
        }
        return true;
    }
}
