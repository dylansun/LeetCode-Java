package org.sdancer.leetcode;

import java.util.*;

public class RemoveDuplicatesFromSortedListII {
	public static ListNode deleteDuplicates(ListNode head){
		if(head == null)
			return head;
		ListNode sentinel = new ListNode(0);
		sentinel.next = head;
		
		ListNode it = head.next;
		ListNode previous = head;
		Set<Integer> dup = new HashSet<Integer>();
		while(it != null){
			//lazy deletion
			if(it.val == previous.val){
				previous.next = it.next;
				dup.add(it.val);
			}
			else{
				previous = it;
			}
			it = it.next;
		}
		
		System.out.println("Duplicates in Hash Set");
		for(Integer i:dup){
			System.out.print(i+"\t");
		}
		System.out.println();
		
		it = head;
		previous = sentinel;
		while(it!=null){
			System.out.println(it.val);
			if(dup.contains(it.val)){
				previous.next = it.next;
			}
			else{
				previous = it;
			}
			it = it.next;
		}
		
		return sentinel.next;
	}
	
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	  
	  public static void main(String[] args){
		  
		  ListNode head = new ListNode(1);
		  ListNode node1 = new ListNode(1);
		  head.next=node1;
		  head = deleteDuplicates(head);
		  System.out.println(head);
		  while(head!=null){
			  System.out.println(head.val);
			  head = head.next;
		  }
	  }
	  
}
