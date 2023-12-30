package Trees;

import java.util.Stack;

import Leetcode_Template.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
    
       /*
        * recursive solution
        */
        // return solhelper(root, 0, targetSum);
    }

    /*
     * recursive solution helper
     */ 
     public boolean solhelper(TreeNode root, int sum, int targetSum){
         if(root == null)
            return false;
         if(root.left == null && root.right == null){
             int newSum = sum + root.val;
             if(newSum == targetSum)
                return true;
         }

         boolean left = solhelper(root.left, sum + root.val, targetSum);
         boolean right = solhelper(root.right, sum + root.val, targetSum);

         if(left == true || right == true){
             return true;
         }
         return false;
     }

     public boolean iterativeSolution(TreeNode root, int targetSum){
    //iteratively solution
      Stack<TreeNode> st = new Stack<>();//stack for traversal
      Stack<Integer> sum = new Stack<>(); //stack to store sum on the way to process node
      if(root == null)
        return false;
      st.push(root);
      sum.push(root.val);
       while(!st.isEmpty())
       {
          TreeNode curr = st.pop();
          Integer res = sum.pop();
          if(curr.right == null && curr.left == null){
              if(res == targetSum ) //only check on reaching child node
                return true;
          }
          if(curr.right != null){
            st.push(curr.right);
            sum.push(res + curr.right.val);
          }
            
          if(curr.left != null){
              st.push(curr.left);
              sum.push(res + curr.left.val);
          }
            
       } 
       return false;
     }
}
