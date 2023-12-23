package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

import Leetcode_Template.TreeNode;

public class MaxDepthBinaryTree {
    /*
     * Max Depth of a binary tree is the height of binary tree
     * Depth of a Node is distance between root to that node generally measured in terms of edges
     * So maximum depth is between root node and leaf node, and maximum of all such depth will be height of that tree
     * Height of a Node : height of a node is distance between that node and the leaf node of that tree measured in terms of edges
     */
    public int maxDepth(TreeNode root){
       // return maxDepthRecursiveHelper(root);
       //return maxDepthIterativeHelper(root);
       return maxDepthBFSHelper(root);
    }

    /*
     * recursive solution
     * Intution: for a node max depth will be Maximum of (depth of left subtree, depth of right subtree) + 1 (for current node)
     * building on this intution we can solve this recursively
     * we will have to handle a base case when root becomes null. we should return 0 .
     * This is a kind of postorder traversal
     */

     public int maxDepthRecursiveHelper(TreeNode root){
        //base case
        if(root == null)
            return 0;
        return Math.max(maxDepthRecursiveHelper(root.left),maxDepthRecursiveHelper(root.right)) + 1;
        
     }

     /**
      * Iterative solution
      * Idea is same as recursive we will use stack to simulate.
      * Here order of subtree visit wont matter as we are not concerned with order in which we visit the subtree nodes
      * but rather that we visit them in DFS manner
      */
      public int maxDepthIterativeHelper(TreeNode root){
        if(root == null)
            return 0;//handline if tree is empty
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();
        stack.push(root);
        depth.push(0);
        TreeNode curr ;
        Integer maxDepth = 0 ;
        Integer currDepth ;
        while(!stack.isEmpty()){
            curr = stack.pop(); 
            currDepth = depth.pop();
            maxDepth = Math.max(currDepth,maxDepth);
            if(curr.left != null ){//order of left right doesnt matter here as we are concerne with height and not order.
                stack.push(curr.left);
                depth.push(currDepth+1);
            }

            if(curr.right != null){
                stack.push(curr.right);
                depth.push(currDepth+1);
            }
        }
        return maxDepth + 1; // +1 for adding root nodes height, we can also have added 1 into depth when we pushed root
        /***
         * Instead of two stacks we could also single stack with Pair classes where we simply push each time the node paired 
         * with its depth
         */

         /*
          * There is also a LEVEL order Traversal Approach
          */
      }
      /**
       * Level Order Traversal or BFS Approach
       * we can do a level order traversal with keeping count of each level visited
       * At end level + 1 will be the max depth of binary tree
       * This is better than 2 stack iterative solution and also little bit in terms of memory since space complexity will be
       * max number of leaf nodes when tree is full
       * @param root
       * @return
       */
      public int maxDepthBFSHelper(TreeNode root){
            if(root == null) // if tree is empty
                return 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            TreeNode curr;
            int depth= 0;
            while(!queue.isEmpty()){
                int size = queue.size();//current elements in queue
                int itr = 0; //iterator to iterate on all current elements till we reach that size
                while(itr < size){
                    curr = queue.poll();
                    if(curr.left != null){
                        queue.offer(curr.left);//adding left child
                    }
                    if(curr.right != null){
                        queue.offer(curr.right); //adding right child
                    }
                    itr += 1 ;
                }
                depth += 1 ; //one level is processed , increment the depth by 1
            }
            return depth; // we dont need +1 as at each level we are alrady doing +1 , do a dry run with a sample tree and it will be clear
      }
}
