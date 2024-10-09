import java.util.ArrayDeque;
import java.util.Queue;

public class BTLevelOrderTraversal {

    public static void levelOrder(Node root){
        //get the size
        //remove process and add children
        //these we do to do level order traversal
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        while(!mq.isEmpty()){
            int count = mq.size();
            for(int i = 0 ; i< count; i++){
                Node temp = mq.remove();
                System.out.print(temp.data + " ");
                if(temp.left != null){
                    mq.add(temp.left);
                }
                if(temp.right != null){
                    mq.add(temp.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = TreeImpl.treeCosntruction();
       // TreeImpl.display(root);
       levelOrder(root);
    }
}
