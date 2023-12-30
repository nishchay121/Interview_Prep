package Trees;

import java.util.Stack;

import Leetcode_Template.TreeNode;

public class SumRootLeafNumber {
    public int sumNumbers(TreeNode root) {
        //iterative preorder
        if(root == null)
            return 0;
        Stack<TreeNode> st = new Stack<>();//traversal stack
        Stack<Integer> path = new Stack<>();//stack for number forme
        int sum = 0; //stores result
        st.push(root);
        path.push(root.val);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            int num = path.pop();
            if (curr.left == null && curr.right == null ){
                sum += num;
            }
            if(curr.right != null ){
                st.push(curr.right);
                path.push(num*10 + curr.right.val);
            }
            if(curr.left != null){
                st.push(curr.left);
                path.push(num*10 + curr.left.val);
            }
        }
         return sum;
         /*************** Recursive Solution */
        
        // return pathSumHelper(root, 0);
       
    }

  /**
   *  This is iterative method with return parameter. We can also have void method with global variable.
   *  but global variable comes with memory concern so i went with return parameter
   * @param root
   * @param number value of number formed till traversal of previous node
   * @return returns the number formed from path to leaf node.
   */

    public int pathSumHelper(TreeNode root, int number){
        //if root is null return 0
        if(root == null){
            return 0;
        }
  
        //one base case base case leaf node reached
        if(root.left == null && root.right == null){
            int newNum = number*10 + root.val;
            return newNum;
        }
        int newNumber = number * 10 + root.val;
        int leftNumber = pathSumHelper(root.left, newNumber);
        int rightNumber = pathSumHelper(root.right, newNumber);
        return leftNumber + rightNumber ;

    }
}
