import Leetcode_Template.TreeNode;
/*solution using the pair class */
class Pair{
    int sum;
    int tilt;
    Pair(int sum , int tilt){
        this.sum = sum;
        this.tilt = tilt;

    }
}
public class TiltOfTree {
     int sumVal = 0;

    public int findTilt(TreeNode root) {
       Pair finalSum = tiltHelper(root);
        int finalSum2 = tiltHelper2(root);
       // return finalSum.tilt;
        return sumVal;
    }
    public Pair tiltHelper(TreeNode root){
        if (root == null)
            return new Pair(0,0);
        //get left sum
       Pair leftTilt = tiltHelper(root.left);
        //get right sum
       Pair rightTilt = tiltHelper(root.right);

        int newTilt = Math.abs(leftTilt.sum - rightTilt.sum);
        //update overall tilt
        Pair newPair = new Pair(leftTilt.sum + rightTilt.sum + root.val, leftTilt.tilt + rightTilt.tilt + newTilt);
       return newPair;
    }
    /*second method with Gloabl variable */
    public int tiltHelper2(TreeNode root){
         if (root == null)
             return 0;
         //get left sum
        int leftTilt = tiltHelper2(root.left);
         //get right sum
        int rightTilt = tiltHelper2(root.right);
 
         int newTilt = Math.abs(leftTilt - rightTilt);
         //update overall tilt
         sumVal += newTilt;
         // return sum
         return leftTilt+rightTilt+ root.val;
     }
}
