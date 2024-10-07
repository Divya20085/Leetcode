class Solution {
    public int compress(char[] chars) 
    {
        int n= chars.length;
        StringBuilder sb = new StringBuilder();
        int f=1;
        for(int i=0;i<n;i++)
        {
            char c =chars[i];
            while( i<n-1&&chars[i]==chars[i+1])
            {
                f++;
                i++;
            }
            sb.append(c);
            if(f>1)
            sb.append(f);
            f=1;
        }
        String s1=sb.toString();
        char arr[]=s1.toCharArray();
        for(int i=0;i<arr.length;i++)
        {
            chars[i]=arr[i];
        }
        return arr.length;
    }
}