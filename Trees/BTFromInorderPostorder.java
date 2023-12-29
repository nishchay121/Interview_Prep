package Trees;

import java.util.HashMap;
import java.util.Map;

import Leetcode_Template.TreeNode;

public class BTFromInorderPostorder{

    //main caller function
     public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inorderSize = inorder.length;
        int postorderSize = postorder.length;
        if(inorderSize != postorderSize || inorderSize == 0 || postorderSize == 0)
            return null;
        //put values in map for easy retrieval
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int elements : inorder){
            map.put(elements,count);
            count+=1;
        }
        return buildTreeNodeHelper(inorder,0,inorderSize-1,postorder,0,postorderSize-1,map);
    }
    /*
     * Recursive helper function
     */
     public TreeNode buildTreeNodeHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd, Map<Integer,Integer> map){
        if(inorderEnd < inorderStart || postorderEnd < postorderStart)
            return null;
        int element =  postorder[postorderEnd];
        TreeNode root = new TreeNode(element);
        int index = map.get(element);
        /*
         * index initialization for left and right subtree
         */
        int leftinorderEnd = index - 1;
        int rightinorderStart = index + 1;
        int leftinorderSize = index - inorderStart;
        int leftpostorderEnd = postorderStart + leftinorderSize - 1;
        int rightpostorderStart = leftpostorderEnd + 1;

        TreeNode left = buildTreeNodeHelper(inorder, inorderStart, leftinorderEnd, postorder,postorderStart, leftpostorderEnd,map);
        TreeNode right = buildTreeNodeHelper(inorder, rightinorderStart, inorderEnd, postorder,rightpostorderStart, postorderEnd-1,map);
        root.left = left;
        root.right = right;
        return root;

    }
}