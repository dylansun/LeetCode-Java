package org.sdancer.leetcode;

public class RemoveNtheNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null) 
			return null;
		int count=0;
		ListNode it = head;
		while(it!=null){
			count++;
			it = it.next;
		}
		
		int idx = count -n;
		
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;

		it = sentinel;
		for(int i=0; i< idx ; i++){
			it=it.next;
		}
		
		ListNode tmp = it.next;
		if(n != 1)
		    it.next = tmp.next;
		else
		    it.next = null;
		return sentinel.next;
	}
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
}
