class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        int inf=0x3f3f3f3f;
        int []dp= new int[n];
        Arrays.fill(dp,inf);
        dp[src]=0;
        for(int i=0;i<=k;i++)
        {
            int temp[]=Arrays.copyOf(dp,n);
            for(int j=0;j<flights.length;j++)
            {
                int from=flights[j][0];
                int to=flights[j][1];
                int pr=flights[j][2];
                temp[to]=Math.min(temp[to],dp[from]+pr);
            }
            dp=temp;
        }
        return dp[dst]==inf?-1:dp[dst];
    }
}