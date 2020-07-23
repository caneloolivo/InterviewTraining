package Amazon;

public class LowestCommonAncestorOfABinarySearchTree {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int pVal = p.val;
		int qVal = q.val;
		TreeNode node = root;
		while(node != null) {			
			if(pVal > node.val && qVal > node.val)
				node = node.right;
			else if(node.val > pVal && node.val > qVal)				
				node = node.left;
			else
				return node;
		}
		return null;
	}
}
