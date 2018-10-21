/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    ArrayList<Integer> solution = new ArrayList<Integer>();
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        preorder(A);
        return solution;
    }
    
    public void preorder(TreeNode A){
        if(A != null){
            solution.add(A.val);
            preorder(A.left);
            preorder(A.right);
        }
    }
}
