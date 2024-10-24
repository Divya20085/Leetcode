class Solution {
    public int fib(int n) {
        if(n<=1)
        {
            return n;
        }
        //return fib(n-1)+fib(n-2);
        int a=0,b=1,k=0;
        
        for(int i=2;i<=n;i++)
        {
            k=a+b;
            a=b;
            b=k;
        }
        return k;
      
    }
}