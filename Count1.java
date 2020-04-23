package count;

public class Count1 {

    /**
     * 统计位1的个数,运用位运算
     */
    public int count1(int n){
        int sum=0;
        while (n!=0){
            n&=n-1;
            sum++;
        }
        return sum;
    }

    /**
     * 循环 位运算
     * @param n
     * @return
     */
    public int countBits(int n){
        int res=0;
        int mask=1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask)!=0){
                res++;
            }
            mask<<=1;
        }
        return res;
    }

    public static void main(String[] args) {
        int res1 = new Count1().count1(7);
        int res2 = new Count1().countBits(7);
        System.out.println(res1);
        System.out.println(res2);
    }
}
