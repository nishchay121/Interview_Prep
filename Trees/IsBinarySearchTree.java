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
class BST{
    Boolean isBst;
    long max;
    long min;
    BST(Boolean isBst, long max, long min){
        this.isBst = isBst;
        this.max = max;
        this.min = min;
    }
    BST(){
        this.isBst = null;
        this.max = 0;
        this.min = 0;
    }
 }
class Solution {
    public boolean isValidBST(TreeNode root) {
        // BST res = isValidBSTHelper(root);
        // return res.isBst;
        return isValidBSTHelper2(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public BST isValidBSTHelper(TreeNode root){
        if(root == null){
            return new BST(true, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        BST leftBst = isValidBSTHelper(root.left);
        BST rightBst = isValidBSTHelper(root.right);

        BST currBst = new BST();
        currBst.isBst = (leftBst.isBst && rightBst.isBst) && (root.val > leftBst.max && root.val < rightBst.min);
        currBst.min = Math.min(root.val,Math.min(leftBst.min, rightBst.min));
        currBst.max = Math.max(root.val,Math.max(leftBst.max, rightBst.max));
        return currBst;
    }
    public Boolean isValidBSTHelper2(TreeNode root, Long minVal, Long maxVal){
        if(root == null)
            return true;
        if(root.val <= minVal || root.val >=maxVal){
            return false;
        }
        Boolean leftRes = isValidBSTHelper2(root.left , minVal, (long)root.val);//update max limit as current node val
        Boolean rightRes = isValidBSTHelper2(root.right ,(long) root.val, maxVal);//update min limit as current node val
        return leftRes && rightRes;
    }
}