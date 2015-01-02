package org.sdancer.leetcode;

public class PartitionList {
	public static  class ListNode{
		int val;
		ListNode next;
		ListNode(int val){this.val = val;}
	}
	
	public  static ListNode partition(ListNode head, int x){
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;
		ListNode node = sentinel.next;
		ListNode pre = sentinel;
		
		ListNode sentinel2 = new ListNode(0);
		ListNode node2 = sentinel2;
		while(node!=null){
			//if this node is smaller, 
			//1 insert this node to the min list
			//2 remove it in original
			if(node.val < x){
				
				node2.next = node;
				node2 = node;
				
				ListNode nextNode = node.next;
				pre.next = nextNode;
				node = nextNode;	
			}
			else
			{
				pre = node;
				node = node.next;
			}
			node2.next = sentinel.next;
		}
		return sentinel2.next;
	}
	
	public static void main(String[] args){
		ListNode  head = new ListNode(1);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(2);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode result = partition(head, 3);
		while(result!=null){
			System.out.print(result.val+"\t");
			result = result.next;
		}
	}
}
