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
 /*
 arr[0] = if node is robbed
 arr[1] = if node is not robbed
 */
public class HouseRobberThree {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        //maximum of if root is robbed or not robbed
        return Math.max(res[0],res[1]);
    }
    public int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{0,0};
        }

        int [] leftRes = dfs(root.left);
        int [] rightRes = dfs(root.right);
        //if current node is robbed, we can't rob the direct children
        int robCurr = root.val + leftRes[1] + rightRes[1];
        //if current node is not robbed, then maximum of robbing/not robbing left child + maximum of robing/not robbing right child
        // since we can now consider both the children for robbing as current node is not being robbed 
        // and only current node is direct link between these two children
        int notrobCurr = Math.max(leftRes[0],leftRes[1]) + Math.max(rightRes[0] , rightRes[1]);
        //finally return both values what happens when you rob and if not rob
        return new int[]{robCurr, notrobCurr};
    }
}