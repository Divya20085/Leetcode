class Solution {
    public String[] findRelativeRanks(int[] a) 
    {
        int n=a.length;
        String[] s= new String[a.length];
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(a[i],i);
        }
        Arrays.sort(a);
        for(int i=0;i<map.size();i++)
        {
            int rank=n-i;
            if(rank==1)
            s[map.get(a[i])]="Gold Medal";
            else if(rank==2)
            s[map.get(a[i])]="Silver Medal";
            else if(rank==3)
            s[map.get(a[i])]="Bronze Medal";
            else
            s[map.get(a[i])]=String.valueOf(rank);
        }
        return s;
    }
}