package Trees;

import Leetcode_Template.TreeNode;

public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        //call a helper function  
        int res = isBalancedHelper( root);
        //boolean ans;
        //res > 1 ? ans= false : ans = true;
        if ( res == -1)
           return false;
        return true;
       }
   /*
    * Recursive solution
    */
       public int isBalancedHelper(TreeNode root){
           if(root == null)
               return 0;
           
           int leftDepth = isBalancedHelper(root.left);
           int rightDepth = isBalancedHelper(root.right);
           if(leftDepth == -1 || rightDepth == -1 ) //if any of the left or right is unbalanced lets return unbalanced.
               return -1;
           int res = Math.abs(leftDepth - rightDepth);
           if (res > 1)
               return -1; //if current node is unbalanced.
           return Math.max(leftDepth,rightDepth) + 1;
       }
}
