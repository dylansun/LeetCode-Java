package org.sdancer.leetcode;

public class RotateList {

	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val=x;
			this.next=null;
		}
	}
	
	public ListNode rotateRight(ListNode head, int k){
		if(head == null) return null;
		
		// define a sentinel 
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;
		
		//count list node number
		ListNode it = head;
		ListNode tail = null;
		int n =0;
		while(it!=null){
			// record the tail node 
			if(it.next == null)
				tail = it;
			it=it.next;
			n++;
		}
		
		//if k is greater than n
		//the result is equal to k % n
		k = k % n;
		if(k == 0) return sentinel.next;
		
		//calculate the rotated position from left
		//the first node is indexed by 0
		//the position just before the rotated node 
		int pos = n - k - 1;
		it=sentinel.next;
		while(pos > 0){
			it = it.next;
			pos--;
		}
		
		// rotate 
		head = sentinel.next;
		sentinel.next = it.next;
		tail.next = head;
		it.next = null;
		
		return sentinel.next;
	}
	
}
