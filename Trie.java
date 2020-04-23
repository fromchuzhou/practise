package count;

public class Trie {

    private TrieNode root;

    public Trie() {
        root=new TrieNode();
        root.value=' ';
    }

    /**
     * 插入,构建字典树
     * @param word
     */
    public void insert(String word){
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c-'a']==null){
                ws.children[c-'a']=new TrieNode(c);
            }
            ws=ws.children[c-'a'];
        }
        ws.isWord=true;
    }

    /**
     * 在字典树中查找一个单词
     * @param word
     * @return
     */
    public boolean search(String word){
        TrieNode ws = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c-'a']==null)return false;
            ws=ws.children[c-'a'];
        }
        return ws.isWord;
    }

    /**
     * 以指定前缀开始
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix){
        TrieNode ws = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c-'a']==null)return false;
            ws=ws.children[c-'a'];
        }
        return true;
    }
}
