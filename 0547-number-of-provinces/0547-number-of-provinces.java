class Solution {
    public static void dfs(int n, ArrayList<ArrayList<Integer>> ad, int v[])
    {
        v[n]=1;
        for(int a:ad.get(n))
        {
            if(v[a]==0)
            {
                dfs(a,ad,v);
            }
        }
    }
    public int findCircleNum(int[][] con) 
    {
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        int m=con.length;
        int n=con[0].length;
        for(int i=0;i<n;i++)
        {
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(con[i][j]==1&&i!=j)
                {
                    adjlist.get(i).add(j);
                    adjlist.get(j).add(i);
                }
            }
        }
        int v[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(v[i]==0)
            {
                c++;
                dfs(i,adjlist,v);
            }
        }
        return c;

    }
}