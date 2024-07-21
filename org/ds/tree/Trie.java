package org.ds.tree;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word){

        TrieNode node = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean wordExists(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public boolean prefixExists(String prefix){
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

//    private Search

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("cat");
        trie.addWord("car");
        trie.addWord("cattle");
        System.out.println(trie.wordExists("catt"));
    }

}
