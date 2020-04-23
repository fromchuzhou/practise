package count;


import java.util.ArrayList;
import java.util.List;

public class GenerateParathesis {

    /**
     * 生成有效括号组合
     */
    public void generateAll(char[] current, int pos, List<String> result){
        if (pos == current.length){
            if (valid(current)){
                result.add(new String(current));
            }
        }else{
            current[pos]='(';
            generateAll(current,pos+1,result);
            current[pos]=')';
            generateAll(current,pos+1,result);
        }
    }

    /**
     * 生成有效的括号数
     * @param n
     * @return
     */
    public List<String> generateParathesis(int n){
        ArrayList<String> combinations = new ArrayList<>();
        generateAll(new char[2*n],0,combinations);
        return combinations;
    }

    public boolean valid(char[] current){
        int balance=0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] == '(')balance++;
            else balance--;
            if (balance < 0)return false;
        }
        return balance==0;
    }

    /**
     * 生成
     * @param n
     * @return
     */
    public List<String> generateParathesis1(int n){
        ArrayList<String> ans = new ArrayList<>();
        backTrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    /**
     * 回溯
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public void backTrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max*2){
            ans.add(cur.toString());
            return;
        }
        if (open < max){
            cur.append('(');
            backTrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close < open){
            cur.append(')');
            backTrack(ans,cur,close,open+1,max);
            cur.deleteCharAt(cur.length()-1);
        }


    }


}
