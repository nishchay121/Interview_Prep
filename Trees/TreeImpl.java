
class Node{
    int data; 
    Node left; 
    Node right;

    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class TreeImpl {
    public static void main(String [] args){
        Node n = new Node(5, null, null);
        n.left = new Node(10, null, null);
        n.right = new Node(11,null, null);
        
    }
}
