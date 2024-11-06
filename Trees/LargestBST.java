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
    int min;
    int max;
    int size;
    BST(){
        this.min = 0;
        this.max= 0;
        this.size = 0;
    }
    BST(int min, int max, int size){
        this.min = min;
        this.max = max;
        this.size = size;
    }
}
public class LargestBST {
    public int largestBSTSubtree(TreeNode root) {
        BST res = largestBSTSubtreeHelper(root);
        return res.size;
    }
    public BST largestBSTSubtreeHelper(TreeNode root){
        if(root == null){
            return new BST(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        BST leftNode = largestBSTSubtreeHelper(root.left);
        BST rightNode = largestBSTSubtreeHelper(root.right);

        if(root.val > leftNode.max && root.val < rightNode.min){
            //this is a BST
            BST curr = new BST();
            curr.min = Math.min(root.val,Math.min(leftNode.min,rightNode.min));
            curr.max = Math.max(root.val,Math.max(leftNode.max,rightNode.max));
            curr.size = leftNode.size + rightNode.size + 1;
            return curr;
        }
        else{
            //BST failed
            return new BST(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftNode.size,rightNode.size));
        }
    }
}
