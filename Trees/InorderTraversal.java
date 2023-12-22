package Trees;
/*
 * Leetcode : 94
 * Desc : Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Example : 
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Leetcode_Template.TreeNode;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * this is recursive solution
         */
        
        // List<Integer> res = new ArrayList<>();
        // inorderTraversalHelper(root,res);
        // return res;
        

        /**
         * This is iterative solution
         */
        return inorderIterativeHelper(root);
    }

    /**
     * helper method for recursive solution
     * 
     * @param root Root node
     * @param ans  list of node values ordered inorderly
     */
    public void inorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        inorderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right, ans);
    }

    /**
     * method for iterative solution
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderIterativeHelper(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>(); //to simulate recursive behaviour
        if (root == null)
            return ans;
        TreeNode temp = root; //iterate without changing root
        while (temp != null || !st.isEmpty()) {
            while (temp != null) {
                st.push(temp);//keep pushing left child
                temp = temp.left;
            }
            temp = st.pop();// all left child finished, leaf reached.. pop from stack and go right
            ans.add(temp.val);
            temp = temp.right;

        }
        return ans;
    }

}
