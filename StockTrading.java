package count;

public class StockTrading {

    /**
     * 交易一次的最大利润
     */
    public int maxProfit(int[] prices){
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit=prices[j]-prices[i];
                if (maxProfit<profit){
                    maxProfit=profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 最大利润
     * @param prices
     * @return
     */
   public int maxProfit1(int[] prices){
       int minPrice=Integer.MIN_VALUE;
       int maxProfit=0;
       for (int i = 0; i < prices.length; i++) {
           if (prices[i]<minPrice){
               minPrice=prices[i];
           }else if (prices[i]-minPrice>maxProfit){
               maxProfit=prices[i]-minPrice;
           }
       }
       return maxProfit;
   }

    /**
     * 不限制交易次数
     * @param prices
     * @return
     */
   public int maxProfit2(int[] prices){
       return calculate(prices,0);
   }

    /**
     * 计算
     * @param prices
     * @param s
     * @return
     */
   public int calculate(int[] prices,int s){
       if (prices.length<=s)return 0;
       int max=0;
       for (int i = 0; i < prices.length; i++) {
           int maxprofit=0;
           for (int j = i+1; j < prices.length; j++) {
                if (prices[j]>prices[i]){
                    int profit=calculate(prices,j+1)+prices[j]-prices[i];
                    if (profit>maxprofit){
                        maxprofit=profit;
                    }
                }
           }
           if (max<maxprofit)max=maxprofit;
       }
       return max;
   }

    /**
     * 动态规划,递推
     * @return
     */
   public int maxProfit3(int[] prices){
       int maxprofit=0;
       for (int i = 1; i < prices.length; i++) {
           if (prices[i]>prices[i-1]){
               maxprofit+=prices[i]-prices[i-1];
           }
       }
       return maxprofit;
   }
    /**
     * dp 重点是状态转移方程的定义
     */

    /**
     * 1、当k等于1的时候 状态定义为二维的
     */
    public int maxProfit4(int[] prices){
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[length-1][0];
    }

    /**
     * 空间复杂度为O(1)的解法，因为当前状态是由相邻的状态转移过来的
     * @param prices
     * @return
     */
    public int maxProfit5(int[] prices){
        int n = prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }

    /**
     * 不限制交易次数
     * @param prices
     * @return
     */
    public int maxProfit6(int[] prices){
        int n = prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp=dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,tmp-prices[i]);
        }
        return dp_i_0;
    }

    /**
     * 不限制交易次数，但是需要cooldown，表示每次sell之后需要等一天才能继续交易
     * @param prices
     * @return
     */
    public int maxProfit7(int[] prices){
        int n=prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        int dp_pre_0=0;
        for (int i = 0; i < n; i++) {
            int tmp=dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,dp_pre_0-prices[i]);
            dp_pre_0=tmp;
        }
        return dp_i_0;
    }

    /**
     * 不限制交易次数,但需要支付手续费
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit8(int[] prices,int fee){
        int n=prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp=dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,tmp-prices[i]-fee);
        }
        return dp_i_0;
    }

    /**
     * 当k等于2的时候 略有不同
     * @param prices
     * @return
     */
    public int maxProfit9(int[] prices){
        int n = prices.length;
        int max_k=2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >=0; k--) {
                if (i-1==-1){
                   dp[i][k][0]=0;
                   dp[i][k][1]=Integer.MIN_VALUE;
                   continue;
                }
               dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
               dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][max_k][0];
    }

    /**
     * 空间复杂度为O(1)的解法
     * @param prices
     * @return
     */
    public int maxProfit11(int[] prices){
        int dp_i10=0,dp_i11=Integer.MIN_VALUE;
        int dp_i20=0,dp_i21=Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20=Math.max(dp_i20,dp_i21+price);
            dp_i21=Math.max(dp_i21,dp_i10-price);
            dp_i10=Math.max(dp_i10,dp_i11+price);
            dp_i11=Math.max(dp_i11,-price);
        }
        return dp_i20;
    }
    /**
     * 最多进行k次交易
     * @param prices
     * @return
     */
    public int maxProfit10(int[] prices,int max_k){
        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 0; k--) {
                if (i-1==-1){
                    dp[i][k][0]=0;
                    dp[i][k][1]=Integer.MIN_VALUE;
                }
                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][max_k][0];
    }
}
