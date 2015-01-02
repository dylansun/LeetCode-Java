package org.sdancer.leetcode;

import java.util.*;

public class PopulatingNextRightPointersInEachNodeII {
	public class TreeLinkNode{
		int val;
		TreeLinkNode left, right,next;
		TreeLinkNode(int x){this.val=x;}
	}
	
	private boolean isLeaf(TreeLinkNode leaf){
		return leaf.left==null && leaf.right==null;
	}
	
	//Assumption: the tree is a  full binary tree
	public void connect(TreeLinkNode root){
		if(root == null || isLeaf(root)) return;
		//BFS
		HashMap<TreeLinkNode, Integer> visited = new HashMap<TreeLinkNode,Integer>();
		visited.put(root, 1);
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			TreeLinkNode top = queue.poll();
			int step = visited.get(top);
			if(top.left != null){
				queue.offer(top.left);
				visited.put(top.left, step+1);
			}
			if(top.right!=null){
				queue.offer(top.right);
				visited.put(top.right, step+1);
			}
			TreeLinkNode next = queue.peek();
			if(next!=null && visited.get(top) == visited.get(next)){
				top.next = next;
			}
		}
	}
}
