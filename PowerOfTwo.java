package count;

public class PowerOfTwo {

    /**
     * 2的幂次方问题
     */
    public boolean powerOfTwo(int n){
        if (n==0)return false;
        long x=n;
        return (x&(-x))==x;
    }
    public boolean powerOfTwo1(int n){
        if (n==0)return false;
        long x=n;
        return (x&(x-1))==0;
    }
}
