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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        while(st.size() > 0) {
            Pair p = st.peek();
            if(p.state == 0) {
                result.add(p.node.val);
                if(p.node.left != null) st.push(new Pair(p.node.left, 0));
                p.state++;
            } else if(p.state == 1) {
                if(p.node.right != null) st.push(new Pair(p.node.right, 0));
                p.state++;
            } else if(p.state == 2){
                st.pop();
            }
        }
        return result;
        
    }
}