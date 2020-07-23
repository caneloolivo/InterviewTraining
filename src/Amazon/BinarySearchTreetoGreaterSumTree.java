package Amazon;

public class BinarySearchTreetoGreaterSumTree {
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
	public TreeNode bstToGst(TreeNode root) {
		bstToGstHelper(root, 0);
		return root;
	}
	
	public int bstToGstHelper(TreeNode root, int acum) {
		if(root == null)
			return acum;
		acum = bstToGstHelper(root.right, acum);
		root.val += acum;
		return bstToGstHelper(root.left, root.val);
	}
}
