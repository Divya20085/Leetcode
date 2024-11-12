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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> l= new ArrayList<>();
        inord(root,l);
        return l;
    }
    private void inord(TreeNode root, List<Integer> l)
    {
        if(root!=null)
        {
            inord(root.left,l);
            l.add(root.val);
            inord(root.right,l);
        }
    }
}