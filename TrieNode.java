package count;

public class TrieNode {

    public char value;
    /**
     * 实现一个字典树
     *
     */
    public boolean isWord;
    public TrieNode[] children=new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.value = val;
    }


}
