package dylansun.leetcode;

public class IntersectionofTwoLinkedLists {
	/*
	 * First calculate the length of List A and B, say m and n
	 * then shift the longer one with |m - n|
	 * compare one by one 
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = count_list(headA);
        int n = count_list(headB);
        int delta_length = Math.abs(m - n);
        
    	while(delta_length >0){
    		if(m > n)
    			headA = headA.next;
    		else
    			headB = headB.next;
    		delta_length --;
    	}
    	
    	int len = Math.min(m, n);
    	while(len > 0){
    		if(headA == headB){
    			return headA;
    		}
    		headA = headA.next;
    		headB = headB.next;
    	}
    	return null;
    }
    private int count_list(ListNode l){
    	int length = 0;
    	while(l != null){
    		l = l.next;
    		length ++;
    	}
    	return length;
    }
    public class ListNode{
    	int val;
    	ListNode next;
    	ListNode(int val){
    		this.val = val;
    		this.next = null;
    	}
    }
}
