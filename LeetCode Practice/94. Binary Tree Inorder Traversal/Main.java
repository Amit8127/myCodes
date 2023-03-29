/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        while(st.size() > 0) {
			Pair top = st.peek();
			if(top.state == 0){
				// preorder
				if(top.node.left != null) st.push(new Pair(top.node.left,0));
				top.state++;
			}else if(top.state == 1){
				//inorder
				res.add(top.node.val);
				if(top.node.right != null) st.push(new Pair(top.node.right,0));
				top.state++;
			}
			else if(top.state == 2){
				// postorder
				top.state++;
				st.pop();
			}
		}
        return res;        
    }
}