package Trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import Leetcode_Template.TreeNode;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * Recursive
     */
    public void recursivePostOrderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) // base case
            return;
        recursivePostOrderHelper(root.left, ans);// go left child
        recursivePostOrderHelper(root.right, ans);// go right child
        ans.add(root.val); // at end process the node

    }

    /**
     * Iterative with 2 stack
     */
    public void iterativePostOrderHelper(TreeNode root, List<Integer> ans) {
        if (root == null) // base case to handle empty Tree
            return;
        Deque<TreeNode> st = new ArrayDeque<>();// stack to process our nodes
        Deque<TreeNode> st2 = new ArrayDeque<>();// stack to store our result
        st.push(root);
        while (!st.isEmpty()) { // processing stack becomes empty is loop break cond
            TreeNode curr = st.pop(); // start with root node
            if (curr.left != null)
                st.push(curr.left); // go to left child because in answer stack
                                    // it should be added after right
            if (curr.right != null)
                st.push(curr.right); // go to right child because in answer stack
                                     // it should be added before left child
            st2.push(curr); // this root is our last ans so added to answer stack first
        }
        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }
    }
}
