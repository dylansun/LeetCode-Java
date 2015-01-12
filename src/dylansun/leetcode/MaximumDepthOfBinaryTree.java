package dylansun.leetcode;
import java.util.*;
public class MaximumDepthOfBinaryTree {
    
	/*
	 * Using BFS search to loop the tree nodes layer-wisely
	 * Using a Hash-map to store the depth
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		HashMap<TreeNode, Integer> depthmap = new HashMap<TreeNode, Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int maxdepth = 1;
		q.add(root);
		depthmap.put(root, 1);
		while(!q.isEmpty()){
			TreeNode top = q.poll();
			if(top.left != null){
				q.add(top.left);
				depthmap.put(top.left, depthmap.get(top) + 1);
				if(depthmap.get(top)+1 > maxdepth){
					maxdepth = depthmap.get(top) + 1;
				}
			}
			if(top.right != null){
				q.add(top.right);
				depthmap.put(top.right, depthmap.get(top) + 1);
				if(depthmap.get(top)+1 > maxdepth){
					maxdepth = depthmap.get(top) + 1;
				}
			}
		}
		return maxdepth;
    }
    
   public class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
   }
}
