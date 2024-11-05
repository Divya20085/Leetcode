class Solution {
    public int findJudge(int n, int[][] trust) 
    {
        int in[]=new int[n+1];
        int out[]=new int[n+1];
        int m=trust.length;
        for(int i=0;i<m;i++)
        {
           int a=trust[i][0];
           int b=trust[i][1];
            out[a]++;
            in[b]++;
            
        }
       int ans=-1;
       for(int i=1;i<=n;i++)
       {
        if(in[i]==n-1&&out[i]==0)
        {
            ans=i;
        }
       }
       return ans;
    }
}