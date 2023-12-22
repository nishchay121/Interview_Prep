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
    //Recursive Solution
    public static void main(String[] args) {
        //we call the main 
        Solution sol = new Solution();

    }
}
/*
 * Implemented a leetcode solution style class
 * we will create its object and call to run and test
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //inorderTraversalHelper(root, ans);
        //return ans;
        Stack<TreeNode> st = new Stack<>();
        if (root == null)
            return ans;
        //st.push(root);
        TreeNode temp = root;
        while(temp != null || !st.isEmpty()){
            while (temp != null ){
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            ans.add(temp.val);
            temp = temp.right;

        }
        return ans;
    }
    public void inorderTraversalHelper(TreeNode root,List<Integer> ans ){
        if(root == null)
            return ;
        inorderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right,ans);
    }
}
