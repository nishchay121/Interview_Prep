package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Leetcode_Template.TreeNode;

public class LevelOrderTraversal {
    /*
     * Main caller function
     */
    public List<List<Integer>> levelOrder(TreeNode root){

        // /*********** brute force solution ************/
        // List<List<Integer>> res = new ArrayList<>();
        // //we will need to get the maximum height of the tree to use this
        // int height = heightOfTree(root);
        // for(int i = 0 ; i <height ; i++){
        //     List<Integer> temp = new ArrayList<>();
        //     bruteLevelOrderRecursive(root, 0,i, temp);//at each iteration one new level is generation
        //     res.add(temp);
        //     //TC : O(N2)
        //     //SC : O(N)
        // }
        // return res;

        // /**************** Optimied Recursive ****************/
        // List<List<Integer>> levels = new ArrayList<List<Integer>>();
        // if (root == null) return levels;
        // optimizedLevelOrderRecrusive(root, 0,levels);
        // return levels;

        /** Iterative solution */
        return iterativeLevelOrder(root);
    }

/*
 * function to get height
 */
public int heightOfTree(TreeNode root){
    if(root == null)
        return 0;
    return Math.max(heightOfTree(root.left),heightOfTree(root.right)) + 1;
}
/**
 * Brute force recursive solution
 * we will add kth level to ans if current level = kth leve. here Kth level is represeted by printLevel
 */
public List<Integer> bruteLevelOrderRecursive(TreeNode root, int level, int printLevel, List<Integer> currAns){
    if(root == null)
        return currAns;
    if(level == printLevel){
        currAns.add(root.val);
    }
    bruteLevelOrderRecursive(root.left, level+1, printLevel, currAns);
    bruteLevelOrderRecursive(root.right, level+1, printLevel, currAns);
    return currAns; 


}


   /**
    * Optimized Recursive solution
    * @param node
    * @param level
    */
    public void optimizedLevelOrderRecrusive(TreeNode root, int level, List<List<Integer>> levels) {
        if(root == null){
            return;
        }
        // start the current level, since no such level exist
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

         // fulfil the current level
         levels.get(level).add(root.val);

         // process child nodes for the next level
         if (root.left != null)
            optimizedLevelOrderRecrusive(root.left, level + 1,levels);
         if (root.right != null)
            optimizedLevelOrderRecrusive(root.right, level + 1,levels);
            return;
    }
    //TC : O(N)
    //SC : O(N)

    /*
     * Itertaive solution with Queue DS
     */
    public List<List<Integer>> iterativeLevelOrder(TreeNode root){

        Deque<TreeNode> queue = new ArrayDeque<>();//get the DS
        List<List<Integer>> res = new ArrayList<>();//get the answer list
        if( root== null)
        return res; // return blank if root is null
        queue.offer(root);// add the first root
        
        while(queue.size()>0){ //while queue is not empty
            List<Integer> ans = new ArrayList<>(); //level wise list for storing curr level traversal
            int s = queue.size(); //current size corresponds to elements for current level
            int i = 0 ;
            while(i< s){
                TreeNode temp = queue.poll(); 
                if(temp.left!= null) //go left
                queue.offer(temp.left);
                if(temp.right!= null) //go right
                queue.offer(temp.right);
                ans.add(temp.val); //add the current node
                i++;
            }  
            res.add(ans);  // add the current level to final traversal
        }
        return res; 
        //TC : O(N)
        //SC : O(N)

        //Note: insted of getting size we can also have added NUll after each level to act as a separator.
    }
}
