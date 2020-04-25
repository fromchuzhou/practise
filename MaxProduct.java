package count;

import java.util.Arrays;

public class MaxProduct {

    /**
     * 最大乘积子序列解法 1.暴力递归 2.dp
     */
    public int maxProduct(int[] nums){
        int[][] dp = new int[2][2];
        int res=nums[0];
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x=i%2;
            int y=(i-1)%2;
//            if (nums[i]>=0){
//                dp[x][0]=Math.max(dp[y][0]*nums[i],nums[i]);
//                dp[x][1]=Math.min(dp[y][1]*nums[i],nums[i]);
//            }else{
//                dp[x][0]=Math.max(dp[y][1]*nums[i],nums[i]);
//                dp[x][1]=Math.max(dp[y][0]*nums[i],nums[i]);
//            }
            dp[x][0]=Math.max(Math.max(dp[y][0]*nums[i],dp[y][1]*nums[i]),nums[i]);
            dp[x][1]=Math.min(Math.min(dp[y][1]*nums[i],dp[y][0]*nums[i]),nums[i]);
            res=Math.max(res,dp[x][0]);
        }
        return res;
    }

    /**
     * 暴力法求解
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] subNums = Arrays.copyOfRange(nums, i, j + 1);
                int tmp=1;
                for (int x = 0; x < subNums.length; x++) {
                    tmp*=subNums[x];
                }
                if (tmp>max)max=tmp;
            }
        }
        return max;
    }
}
