
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int lenA=0,lenB=0;
        while(temp1!=null){
           temp1=temp1.next;
           lenA++;
        }
        while(temp2!=null){
            temp2=temp2.next;
            lenB++;
        }
        temp1=headA;
        temp2=headB;
        
        if(lenA>lenB){
            int len=lenA-lenB;
           while( len !=0) {
            temp1=temp1.next;
              len--;
           }
        }

        if(lenA<lenB){
            int len= (lenB-lenA);
           while( len !=0) {
            temp2=temp2.next;
              len--;
           }
        }
          while(temp1 !=temp2 ){
               temp1=temp1.next;
               temp2=temp2.next;
           }
        return temp1;
    }
}