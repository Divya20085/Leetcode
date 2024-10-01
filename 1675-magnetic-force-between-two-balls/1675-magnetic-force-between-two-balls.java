class Solution {
    public int maxDistance(int[] p, int m) 
    {
       Arrays.sort(p);
       int l=1,r=p[p.length-1]-p[0];
       int ans =-1;
       while(l<=r)
       {
        int mid=l+(r-l)/2;
        int lp=p[0],balls=1;
        for(int i=1;i<p.length;i++)
        {
            if(p[i]-lp>=mid)
            {
                lp=p[i];
                balls++;
            }
        }
        if(balls>=m)
        {
            ans=mid;
            l=mid+1;
        }
        else
        {
            r=mid-1;
        }
       }
       return ans;
    }
}