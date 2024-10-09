import java.util.Stack;

class Node{
    int data; 
    Node left; 
    Node right;

    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    Node n ;
    int state;
    Pair(Node n, int state){
        this.n = n;
        this.state = state;
    }
}

public class TreeImpl {

  

    public static void display(Node n){
        if(n == null){
            return ;
        }
        String left,right;
        left = n.left == null ? "." : String.valueOf(n.left.data);
        right = n.right == null ?"." : String.valueOf(n.right.data);
        System.out.println(left+" <-- " + n.data + " --> " + right);
        //call left and right subtree
        display(n.left);
        display(n.right);
    }

    public static void traversal(Node n ){
        if(n == null){
            return;
        }
        //preporder
        System.out.print(" " + n.data);
        traversal(n.left);
        traversal(n.right);
    }

    public static void allTraversal(Node n){
        if(n == null){
            return;
        }
        //preporder
        System.out.println(" preorder " + n.data);
        allTraversal(n.left);
        System.out.println(" inorder " + n.data);
        allTraversal(n.right);
        System.out.println(" postorder " + n.data);
    }

    public static Node treeCosntruction(){
        Integer[] nodes = {50,30,16,null,null,8,9,null,null,null,70,6,null,12,null,null,40};
        Node n = new Node(nodes[0]);
        Pair p = new Pair(n,1);
        Stack<Pair> st = new Stack<>();
        st.push(p);
        int idx = 1;
        //Tree construction
        while(!st.isEmpty() && idx < nodes.length){
            Pair temp = st.peek();
            if(temp.state == 1){
                //we should not create a pair of null node and push
                if (nodes[idx] != null){
                    //create new node and assign to current element left
                    temp.n.left = new Node(nodes[idx]);
                    //create a new pair with left value and state 1
                    Pair np = new Pair(temp.n.left,1);
                    //push current new pair to stack top
                    st.push(np);
                }
                //increment the state
                temp.state+=1;
                idx++;
               
            }

            else if (temp.state == 2){
                if (nodes[idx] != null){
                    //create new node and assign to current element right
                    temp.n.right = new Node(nodes[idx]);
                    //create a new pair with left value and state 1
                    Pair np = new Pair(temp.n.right,1);
                    //push current new pair to stack top
                    st.push(np);
                }
                //increment the state
                temp.state+=1;
                idx++;
            }

            else{
                //pop the element
                st.pop();
            }
            
        }
        return n;
    }
    public static void main(String [] args){
       
       Node root = treeCosntruction();
        System.out.println("Tree Display Starts");
        //Tree Display,pass the root node
        display(root);
        //Tree traversal

        traversal(root);
        System.out.println();
        allTraversal(root);
    }

}
