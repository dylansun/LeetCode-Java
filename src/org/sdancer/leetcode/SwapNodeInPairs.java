package org.sdancer.leetcode;

public class SwapNodeInPairs {
	
	
	public static class ListNode{
		int val ;
		ListNode next;
		ListNode(int x){
			this.val = x;
			this.next = null;
		}
	}
	public static void main(String[] args){
		ListNode head  = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		ListNode it = head;
		System.out.println("Original");
		while(it != null){
			System.out.println(it.val);
			it = it.next;
		}
		head = swapPairs(head);
		it = head;
		System.out.println("After Swap");
		while(it != null){
			System.out.println(it.val);
			it = it.next;
		}
	}
}
