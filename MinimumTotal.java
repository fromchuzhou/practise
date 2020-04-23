package count;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {

    /**
     * 三角形的最小路径和 动态规划的实现方式
     */
    public int minimumTotal(List<List<Integer>> triangle){
        int level=triangle.size();
        int[] min = new int[level + 1];
        for (int i = level-2; i >=0; i--) {
            int len = triangle.get(i).size();
            for (int j = 0; j < len; j++) {
                min[j]=Math.min(min[j],min[j+1])+triangle.get(i).get(j);
            }
        }
        return min[0];
    }

    /**
     * 递归加记忆化的实现方式，自顶向下
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle){
        int level = triangle.size();
        List<List<Integer>> memory = new ArrayList<>();
        memory.add(new ArrayList<>());
        return helper(triangle,0,0,level,memory);
    }


    public int helper(List<List<Integer>> triangle,int x,int y,int level,List<List<Integer>> memory){
       if (x>=level || y>triangle.get(x).size()){
           return 0;
       }
       if (x==level-1 && memory.get(x).isEmpty()){
           for (int i = 0; i < memory.get(x).size(); i++) {
               memory.get(x).add(triangle.get(x).get(i));
           }
       }
       if (!memory.get(x).isEmpty() && y<memory.get(x).size() && memory.get(x).get(y)!=null){
           return memory.get(x).get(y);
       }
       if (memory.size()<level){
           memory.add(new ArrayList<Integer>());
       }
        int left = helper(triangle, x + 1, y, level, memory);
        int right = helper(triangle, x + 1, y + 1, level, memory);
        memory.get(x).add(Math.min(left,right)+triangle.get(x).get(y));
        return memory.get(x).get(y);
    }
}
