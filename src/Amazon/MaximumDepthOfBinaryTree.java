package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
	     }
	 }
	 public int maxDepth(TreeNode root) {		 
		 int result = 0;
		 if(root == null)
			 return result;
	        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
	        nodes.offer(root);
	        while(!nodes.isEmpty()) {
	        	int size = nodes.size();
	        	while(size > 0) {
	        		TreeNode node = nodes.poll();
	        		if(node.left != null)
	        			nodes.offer(node.left);
	        		if(node.right != null)
	        			nodes.offer(node.right);
	        		size--;
	        	}
	        	result++;
	        }
	        return result;
	}
	 
}
