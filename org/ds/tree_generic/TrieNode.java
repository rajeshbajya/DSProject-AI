package org.ds.tree_generic;

public class TrieNode {
    TrieNode [] children;
    boolean isEndOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
        System.out.println("Created...");
    }
}
