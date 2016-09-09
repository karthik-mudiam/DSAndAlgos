import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public static TrieNode root;
  public Solution() {
    root = new TrieNode();
  }
  
  // Defining Trie data structure
  public class TrieNode {
    Map<Character, TrieNode> childRef;
    boolean endOfWord;
    public TrieNode() {
      childRef = new HashMap<Character, TrieNode>();
      endOfWord = false;
    }
  }
  
  // Insert into Trie
  public void insert(String symbol) {
    char[] charWord = symbol.toCharArray();
    // System.out.println(charWord);
    TrieNode current = root;
    for(int i=0;i<charWord.length;i++) {      
      if(current.childRef.containsKey(charWord[i])) {
        current = current.childRef.get(charWord[i]);
      }
      else {
        TrieNode node = new TrieNode();
        if(i == charWord.length-1) { node.endOfWord = true;}
        // System.out.println(charWord[i]);
        current.childRef.put(charWord[i], node);
        current = node;
      }
    }
  }
  
  // Search if a given string exists in a Trie
  // endOfWord can be used to identify if the exact word(not a substring) is present
  public boolean search(String word) {
    char[] charWord = word.toCharArray();
    TrieNode curr = root;
    for(int i=0;i<charWord.length;i++) {
      if(curr.childRef.containsKey(charWord[i])) {
        curr = curr.childRef.get(charWord[i]);
      }
      else {
        return false;
      }
    }
    return true;
    // if(curr.endOfWord) {
    //   return true;
    // }
    // return false;
  }
  
  public static void main(String[] args) {        
    String[] symbols = { "I", "Am", "cro", "Na", "le", "abc" };
    Solution solve = new Solution();    
    for(int i=0; i < symbols.length ; i++) {
      solve.insert(symbols[i]);
    }
    System.out.println(solve.search("Am"));
    String[] chemicals = { "Amazon", "Microsoft", "Google" };
    Map<String, String> chemicalToSymbol = new HashMap<String, String>();
    for(int i=0; i < chemicals.length; i++) {
      findSymbol(solve, chemicals[i], chemicalToSymbol);
    }
    for(Map.Entry<String, String> entry : chemicalToSymbol.entrySet()) {
      System.out.println(entry);
    }
  }
  
  // Take all combinations of the chemical in forward direction and store the longest symbol match in a map 
  public static void findSymbol(Solution solve, String chemical, 
                                Map<String, String> chemicalToSymbol) {
    for(int i=0;i<chemical.length();i++) {
      for(int j=i;j<chemical.length();j++) {
        String searchString = chemical.substring(i,j+1);
        if(solve.search(searchString)) {
          System.out.println(searchString);
          if(chemicalToSymbol.containsKey(chemical)) {
            if(chemicalToSymbol.get(chemical).length() < searchString.length()) {              
              chemicalToSymbol.put(chemical, searchString);
            }
          }
          else {
            chemicalToSymbol.put(chemical, searchString);
          }
        }
      }
    }
  }
}

