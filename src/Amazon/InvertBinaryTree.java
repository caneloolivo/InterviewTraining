package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
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
	 public TreeNode invertTree(TreeNode root) {
		 if(root == null)
			 return null;
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.offer(root);
		 while(!queue.isEmpty()) {
			 TreeNode node = queue.poll();
			 TreeNode tmp = node.left;
			 node.left = node.right;
			 node.right = tmp;
			 if(node.left != null)
				 queue.offer(node.left);
			 if(node.right != null)
				 queue.offer(node.right);
		 }
		 return root;
	 }
}
