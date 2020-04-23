package count;

import java.util.HashMap;

public class ClimbStairs {

    /**
     * 爬楼梯,采用递归的方式
     */
    public int climbStairs(int n){
        if (n == 1 || n == 2 || n==0)return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * 记忆化递归
     * @param n
     * @return
     */
    public int climbStairs2(int n, HashMap<Integer,Integer> map){
        if (n == 1 || n == 2 || n==0)return n;
        if (!map.containsKey(n)){
            map.put(n,climbStairs2(n-1,map)+climbStairs2(n-2,map));
        }
        return map.get(n);
    }

    public int climbStairs3(int n){
        if (n == 1 || n == 2 || n==0)return n;
        int[] mem = new int[n];
        mem[0]=1;
        mem[1]=2;
        for (int i = 2; i < n; i++) {
            mem[i]=mem[i-1]+mem[i-2];
        }
        return mem[n-1];
    }

    public static void main(String[] args) {
        int i = new ClimbStairs().climbStairs3(10);
        System.out.println(i);
    }
}
