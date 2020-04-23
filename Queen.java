package count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen {

    /**
     * n皇后问题的解法
     */
    public List<String[]> solveQueens(int n){
        ArrayList<String[]> res = new ArrayList<>();
        helper(0,new boolean[n],new boolean[2*n],new boolean[2*n],new String[n],res);
        return res;
    }


    private void helper(int r,boolean[] cols,boolean[] d1,boolean[] d2,String[] board,List<String[]> res){
          if (r == board.length){
              res.add(board.clone());
          }else{
              for (int i = 0; i < board.length; i++) {
                  int id1=r-i+board.length;int id2=r+i;
//                  System.out.printf("id1=%d,id2=%d",id1,id2);
//                  System.out.println();
                  if (!cols[i] && !d1[id1] && !d2[id2]){
                      char[] row = new char[board.length];
                      Arrays.fill(row,'.'); row[i]='Q';
                      board[r]=new String(row);
                      cols[i]=true;d1[id1]=true;d2[id2]=true;
                      helper(r+1,cols,d1,d2,board,res);
                      cols[i]=false;d1[id1]=false;d2[id2]=false;
                  }
              }
          }
    }

    public static void main(String[] args) {
        List<String[]> strings = new Queen().solveQueens(6);
        for (String[] board : strings) {
            for (String s : board) {
                System.out.println(s);
            }
            System.out.println("=======");
        }
    }
}
