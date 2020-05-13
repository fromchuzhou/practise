package count;

public class CoinChange {

    /**
     * 零钱兑换,暴力法
     */
    public int coinChange(int[] coins,int amount){
        return helper(0,coins,amount);
    }

    public int helper(int idxCoin,int[] coins,int amount){
        if (amount == 0)return 0;
        if (idxCoin<coins.length && amount >0){
            int maxVal = amount / coins[idxCoin];
            int minCost=Integer.MAX_VALUE;
            for (int i = 0; i <= maxVal; i++) {
                if (amount>=i*coins[idxCoin]){
                    int res=helper(idxCoin+1,coins,amount-i*coins[idxCoin]);
                    if (res!=-1){
                        minCost=Math.min(minCost,i+res);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins,int amount){
        return 0;
    }
}
