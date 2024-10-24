package Trees;

import Leetcode_Template.TreeNode;

class BalNode{
    Boolean isBal;
    int height;
    BalNode(Boolean isBal, int height){
        this.isBal = isBal;
        this.height = height;
    }
    BalNode(){
        this.isBal = null;
        height = 0;
    }
}
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

    
       /*
        * Using custom class
        */

    public BalNode isBalancedHeler2(TreeNode root){
        if(root == null){
            return new BalNode(true, 0);
        }
        BalNode leftBalNode = isBalancedHeler2(root.left);
        BalNode rightBalNode = isBalancedHeler2(root.right);

        BalNode currNode = new BalNode();
        currNode.isBal = Math.abs(leftBalNode.height - rightBalNode.height) <=1 && leftBalNode.isBal && rightBalNode.isBal;
        currNode.height = Math.max(leftBalNode.height,rightBalNode.height) + 1;
        return currNode;
    }

}
