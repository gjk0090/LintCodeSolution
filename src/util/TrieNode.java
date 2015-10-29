package util;

public class TrieNode {
    public TrieNode[] children;
    public boolean hasWord;
    
    public TrieNode() {
         children = new TrieNode[26];
         hasWord = false;
    }
}
