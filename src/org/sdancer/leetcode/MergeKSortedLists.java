package org.sdancer.leetcode;
import java.util.*;
public class MergeKSortedLists {
	public  static ListNode mergeKLists(ArrayList<ListNode> lists){
		Queue<ListNode> queue = new LinkedList<ListNode>(lists);
		while(queue.size()>1){
			ListNode h1 = queue.poll();
			ListNode h2 = queue.poll();
			queue.add(mergeLists(h1,h2));
		}
		return queue.peek();
	}
	
	public  static ListNode mergeKLists_1by1(ArrayList<ListNode> lists){
		ListNode sentinel = new ListNode(Integer.MIN_VALUE);
		for(int i=0; i< lists.size();i++){
			mergeLists(sentinel,lists.get(i));
		}
		return sentinel.next;
	}
	public static ListNode mergeLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode sentinel = new ListNode(0);
		ListNode it=null;
		if(l1.val < l2.val){
			it = l1;
			l1 = l1.next;
		}
		else{
			it = l2;
			l2 = l2.next;
		}
		sentinel.next = it;
		while(l1!=null && l2!= null){
			if(l1.val < l2.val){
				it.next = l1;
				l1 = l1.next;
			}
			else{
				it.next = l2;
				l2 = l2.next;
			}
			it = it.next;
		}
		if(l1 !=null){
			it.next = l1;
		}
		if(l2 != null){
			it.next = l2;
		}
		return sentinel.next;
	}
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val = x;
			this.next = null;
		}
	}
	public static void mergektest(){
		ListNode l1 = new ListNode(0);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(8);
		l1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode l2 = new ListNode(1);
		ListNode l2node1 = new ListNode(3);
		ListNode l2node2 = new ListNode(5);
		ListNode l2node3 = new ListNode(7);
		ListNode l2node4 = new ListNode(9);
		ListNode l2node5 = new ListNode(12);
		ListNode l2node6 = new ListNode(33);
		ListNode l2node7 = new ListNode(99);
		l2.next = l2node1;
		l2node1.next = l2node2;
		l2node2.next = l2node3;
		l2node3.next = l2node4;
		l2node4.next = l2node5;
		l2node5.next = l2node6;
		l2node6.next = l2node7;
		
		ListNode l3 = new ListNode(-99);
		ListNode l3node1 = new ListNode(-22);
		ListNode l3node2 = new ListNode(-1);
		ListNode l3node3 = new ListNode(14);
		ListNode l3node4 = new ListNode(17);
		ListNode l3node5 = new ListNode(18);
		l3.next = l3node1;
		l3node1.next = l3node2;
		l3node2.next = l3node3;
		l3node3.next = l3node4;
		l3node4.next = l3node5;
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		
		ListNode head = mergeKLists(lists);
		ListNode it = head;
		while(it!=null){
			System.out.println(it.val+"\t");
			it=it.next;
		}
	}
	public static void mergetest(){
		ListNode l1 = new ListNode(0);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(8);
		l1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode l2 = new ListNode(1);
		ListNode l2node1 = new ListNode(3);
		ListNode l2node2 = new ListNode(5);
		ListNode l2node3 = new ListNode(7);
		ListNode l2node4 = new ListNode(9);
		ListNode l2node5 = new ListNode(12);
		ListNode l2node6 = new ListNode(33);
		ListNode l2node7 = new ListNode(99);
		l2.next = l2node1;
		l2node1.next = l2node2;
		l2node2.next = l2node3;
		l2node3.next = l2node4;
		l2node4.next = l2node5;
		l2node5.next = l2node6;
		l2node6.next = l2node7;
		
		ListNode head = mergeLists(l1,l2);
		ListNode it = head;
		while(it!=null){
			System.out.println(it.val+"\t");
			it=it.next;
		}
	}
	public static void main(String[] args){
		mergektest();
	}
}
