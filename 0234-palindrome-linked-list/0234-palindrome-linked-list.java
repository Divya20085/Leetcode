class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp!=null)
        {
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null)
        {
            if(st.pop()==temp.val)
            {
                temp=temp.next;
            }
            else
            return false;
        }
        return true;

    }
}