package count;

public class Pow {

    /**
     * 求 x的n次方,利用递归求解
     */
    public double pow(double x,int n){
       long n1=n;
       if (n1<0){
           x=1/x;
           n1=-n1;
       }
       return fastPow(x,n1);
    }

    public double fastPow(double x,long n){
        if (n==0){
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n%2==0){
              return half*half;
        }else{
             return  x*half*half;
        }
    }


    /**
     * 快速幂等算法(循环)
     * @param
     */
    public double myPow(double x,int n){
        if (n==0){
            return 1.0;
        }
        long N=n;
        if (N < 0){
            x=1/x;
            System.out.println("现在的x是"+x);
            N=-N;
        }
        double res=1.0;
        double current_data=x;
        for (long i = N; i >0; i=i/2) {
            if (i % 2==1){
                res=res*current_data;
            }
            current_data=current_data*current_data;
        }
       return res;
    }

    public static void main(String[] args) {
        double pow = new Pow().myPow(2.2, -5);
        System.out.println(pow);
    }
}
