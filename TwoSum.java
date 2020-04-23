package count;

import java.util.HashMap;

public class TwoSum {

    /**
     * 求两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp=target-nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i){
                res[0]=map.get(tmp);
                res[1]=i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] res = new TwoSum().twoSum(arr, 5);

        for (int re : res) {
            System.out.println(re);
        }
    }
}
