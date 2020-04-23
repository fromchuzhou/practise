package count;

public class Mysqrt {
    /**
     * 求解一个整数的平方根,使用二分法
     */
    public int mySqrt(int x){
        if (x==0 || x==1)return x;
        int left=1;
        int right=x;
        int res=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (mid==x/mid){
                return mid;
            }else if (mid > x/mid){
                right=mid-1;
            }else{
                left=mid+1;
                res=left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new Mysqrt().mySqrt(4);
        System.out.println(i);
    }
}
