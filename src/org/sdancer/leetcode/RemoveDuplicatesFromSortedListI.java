package org.sdancer.leetcode;

 
public class RemoveDuplicatesFromSortedListI {
	public ListNode deleteDuplicates(ListNode head){
		if(head == null)
			return head;
		ListNode it = head.next;
		ListNode previous = head;
		while(it != null){
			//lazy deletion
			if(it.val == previous.val){
				previous.next = it.next;
			}
			else{
				previous = it;
			}
			it = it.next;
		}
		return head;
	}
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	  
}
