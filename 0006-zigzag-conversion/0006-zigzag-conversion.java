class Solution {
    public String convert(String s, int n) 
    {
        if(n==1||n>=s.length())
        return s;
        boolean goingdown = false;
        StringBuilder[] arr = new StringBuilder[n];
        int cur=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=new StringBuilder();
        }
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            arr[cur].append(c);
            if(cur==0||cur==n-1)
            {
                goingdown=!goingdown;
                
            }
            cur+=goingdown ? 1:-1;

        }
        StringBuilder res= new StringBuilder();
        for(int i=0;i<n;i++)
        {
            res.append(arr[i]);
        }
        return  res.toString();
    }
}