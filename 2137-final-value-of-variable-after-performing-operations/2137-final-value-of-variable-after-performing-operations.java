class Solution {
    public int finalValueAfterOperations(String[] op) 
    {
        int a=0;
        for(int i=0;i<op.length;i++)
        {
            if(op[i].charAt(1)=='+')a++;
            else
            a--;
        }
        return a;
    }
}