package Amazon;

import java.util.Stack;

public class KthSmallestElementInABST {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();        
        stack.push(root);
        while(!stack.isEmpty()){
            while(root != null){
                stack.push(root.left);
                root = root.left;
            }
           root = stack.pop();
            if(--k == 0)
                return root.val;
            root = root.right;
        }
        return k;
    }
}
