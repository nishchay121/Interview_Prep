package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Leetcode_Template.TreeNode;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        return iterativeSolution(root, targetSum);

        /*
         * recursive solution
         */
        // List<List<Integer>> res = new ArrayList<>();
        // List<Integer> currPath = new ArrayList<>();
        // return solhelper(root, 0, targetSum, res, currPath);
    }

    /*
     * recursive solution helper
     */
    public void solhelper(TreeNode root, int sum, int targetSum, List<List<Integer>> res, List<Integer> currPath) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            int newSum = sum + root.val;
            if (newSum == targetSum) {
                currPath.add(root.val);
                res.add(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);// backtrack
                return;
            }

        }
        currPath.add(root.val);
        solhelper(root.left, sum + root.val, targetSum, res, currPath);
        solhelper(root.right, sum + root.val, targetSum, res, currPath);

        currPath.remove(currPath.size() - 1);// backtrack

    }

    public List<List<Integer>> iterativeSolution(TreeNode root, int targetSum) {
        // iteratively solution
        Stack<TreeNode> st = new Stack<>();// stack for traversal
        Stack<Integer> sum = new Stack<>(); // stack to store sum on the way to process node
        Stack<List<Integer>> pathStack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        if (root == null)
            return result;
        st.push(root);
        sum.push(root.val);
        currPath.add(root.val);
        pathStack.push(currPath);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            Integer res = sum.pop();
            currPath = pathStack.pop();
            if (curr.right == null && curr.left == null) {
                if (res == targetSum) // only check on reaching child node
                {
                    result.add(new ArrayList<>(currPath));
                }
            }
            if (curr.right != null) {
                st.push(curr.right);
                sum.push(res + curr.right.val);
                currPath.add(curr.right.val);
                pathStack.push(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }

            if (curr.left != null) {
                st.push(curr.left);
                sum.push(res + curr.left.val);
                currPath.add(curr.left.val);
                pathStack.push(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }

        }
        return result;
    }
}
