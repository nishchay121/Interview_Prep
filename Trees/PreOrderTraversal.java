package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Leetcode_Template.TreeNode;

public class PreOrderTraversal {
    
     public List<Integer> preorderTraversal(TreeNode root) {
        //preorder --> Root, left , right
        List<Integer> ans = new ArrayList<>();
          //** Recursive */
        // recursivePreOrderHelper(root, ans);
        // return ans;

        //** Iterative */
        iterativePreOrderHelper(root,ans);
        return ans;

    }
    /**
     * recursive solution
     */
    public void recursivePreOrderHelper(TreeNode root, List<Integer> ans){
        if (root == null)//base case
            return ;
        ans.add(root.val);
        recursivePreOrderHelper(root.left, ans); // recurse on left child
        recursivePreOrderHelper(root.right, ans); //recurse on right child

    }

     /**
      * Iterative solution
      */
      public void iterativePreOrderHelper(TreeNode root, List<Integer> ans){
        //root null means empty tree. return
        if(root == null)
            return ;
       // Stack<TreeNode> st = new Stack<>();
       /**
        * in prod it's better to use Deque for both queue and stack so using that now
        */
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode itr = root; //iterate through iterator node without changing root of tree
        st.push(itr); //push the first node for processing
        while(!st.isEmpty()){//stack becomes empty is condition to break out of loop
            itr = st.pop();
            ans.add(itr.val);
            if(itr.right != null) //add right node first since we want to process left child first and stack if LIFO
                st.push(itr.right);
            if(itr.left != null ) // add left child second as we want left to be processed before right and stack is LIFO
                st.push(itr.left);

        }

        /**
         *  ************** Another Approach **********************
         * above we can see that as soon as left child is inserted , it is being popped
         * so why even bother pushing to stack
         * just push right child and process by going left 
         * if ever left becomes null go right by popping from stack.
         * no difference time complexity or space complexity just an observation
         */
      }
}
