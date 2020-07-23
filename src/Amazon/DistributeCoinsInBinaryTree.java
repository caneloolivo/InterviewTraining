package Amazon;

public class DistributeCoinsInBinaryTree {
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
	int result;
	public int distributeCoins(TreeNode root) {
        result = 0;        
        dfs(root);
        return result;
    }
	public int dfs(TreeNode node) {
		if(node == null)
			return 0;
		int l = dfs(node.left);
		int r = dfs(node.right);
		result += Math.abs(l) + Math.abs(r);
		return node.val + l +r -1;
	}
}
