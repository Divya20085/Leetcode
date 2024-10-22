class Solution {
    public boolean isValid(String s) {
        
        int n=s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            {
                stack.push(s.charAt(i));
            }
            else
            {
                if(stack.isEmpty()||s.charAt(i)==')'&&stack.pop()!='('||s.charAt(i)==']'&&stack.pop()!='['||s.charAt(i)=='}'&&stack.pop()!='{')
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}