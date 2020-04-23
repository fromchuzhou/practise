package count;

import java.util.HashMap;
import java.util.Map;

public class Majority {


    /**
     * 求一组元素中出现次数最多的数且次数大于用元素数量的一半 使用map
     */
    public int majorityElement(int[] nums){
        Map<Integer, Integer> map = countNum(nums);

        Map.Entry<Integer,Integer> res=null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (res==null || entry.getValue() > res.getValue() ){
                res=entry;
            }
        }
        return res.getKey();
    }

    public Map<Integer,Integer> countNum(int[] nums){
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }
    public int countInRange(int[] nums,int num,int low,int high){
        int count=0;
        for (int i = low; i <= high; i++) {
            if (nums[i]==num){
                count++;
            }
        }
        return count;
    }
    public int majorityElement1(int[] nums,int low,int high) {
        if (low==high)return nums[low];
        int mid = low + (high - low) / 2;
        int left = majorityElement1(nums, low, mid);
        int right = majorityElement1(nums, mid+1, high);
        if (left==right)return left;
        int leftNumber = countInRange(nums, left, low, high);
        int rightNumber = countInRange(nums, right, low, high);
        return leftNumber>rightNumber? left:right;
    }
}
