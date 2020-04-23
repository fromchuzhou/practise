package count;

public class Stock {

    /**
     * 买卖股票的贪心算法求解
     */
    public int maxProfit(int[] prices){
        int maxProfit=0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1]){
                maxProfit+=(prices[i+1]-prices[i]);
            }
        }
        return maxProfit;
    }

    /**
     * 暴力法求解
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices){
        return calculate(prices,0);
    }


    /**
     * 计算利润
     * @param prices
     * @param s
     * @return
     */
    public int calculate(int[] prices,int s){
        if (s>=prices.length)return 0;
        int max=0;
        for (int i = s; i < prices.length; i++) {
            int maxprofit=0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]>prices[i]){
                    int profit = calculate(prices, j + 1) + prices[j] - prices[i];
                    if (profit>maxprofit)maxprofit=profit;
                }
            }
            if (maxprofit>max)max=maxprofit;
        }
        return max;
    }

}
