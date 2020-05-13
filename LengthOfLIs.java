package count;

public class LengthOfLIs {
    /**
     * 最长上升子序列 DP的方式
     */
    public int lengthOfLis(int[] nums){
        if (nums==null || nums.length==0)return 0;
        int res=1;
        int[] dp = new int[nums.length + 1];
        dp[0]=1;
        int maxans=1;
        for (int i = 1; i < nums.length; i++) {
            int maxval=0;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    maxval=Math.max(maxval,dp[j]);
                }
                dp[i]=maxval+1;
                maxans=Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }

    /**
     *
      * @param nums
     * @return
     */
   public int lengthOfLiS(int[] nums){
       if (nums == null || nums.length==0)return 0;
       int[] d = new int[nums.length];
       int len=1;
       d[len]=nums[0];
       for (int i = 0; i < nums.length; i++) {
           if (d[len]<nums[i])d[++len]=nums[i];
           else{
               int left=1,right=len,pos=0;
               while (left<=right){
                   int mid=left+(right-left)>>2;
                   if (d[mid]<nums[i]){
                       pos=mid;
                       left=mid+1;
                   }else{
                       right=mid-1;
                   }
               }
               d[pos+1]=nums[i];
           }
       }
       return len;
   }

}
