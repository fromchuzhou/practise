package count;

import java.util.*;

public class ThreeSum  {
    
    /**
     * 求给定数组中三数之和等于0的组合,要求不能重复
     */
   public Set<List<Integer>> threeSum(int[] nums){

       if (nums==null || nums.length<3){
           return Collections.emptySet();
       }
       Set<List<Integer>> res = new HashSet<>();

       HashMap<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           map.put(nums[i],i);
       }

       for (int i = 0; i < nums.length-2; i++) {
           int target=-nums[i];
           for (int j = i+1; j < nums.length; j++) {
               int tmp=target-nums[j];
               if (map.containsKey(tmp) && map.get(tmp)!= i && map.get(tmp)!= j){
                   ArrayList<Integer> list = new ArrayList<>(3);
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(tmp);
                  list.sort(Comparator.naturalOrder());
                  res.add(list);
               }
           }
       }
       return res;
   }


    /**
     * 采用一个循环两个指针进行查找
     * @param nums
     * @return
     */


    public List<List<Integer>> threeSum1( int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (nums==null || length<3)return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) break;
            if (i>0 && nums[i]==nums[i-1])continue;
            int l=i+1;
            int r=length-1;
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l]==nums[l+1])l++;
                    while (l<r && nums[r]==nums[r-1])r--;
                    l++;
                    r--;
                }else if (sum <0) l++;
                else if (sum >0) r--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, 3, -5};
        List<List<Integer>> res = new ThreeSum().threeSum1(arr);
        System.out.println(res);
    }
}
