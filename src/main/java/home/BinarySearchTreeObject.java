package home;

public class BinarySearchTreeObject {

	private NodeObject root;
    private NodeObject parent;
    private NodeObject node;
 
    public boolean isEmpty() {
        return root==null ;
    }
 
    public NodeObject insert(NodeObject node, int data) {
        //insert code to check if node is null, if it is return a new node
        //recursively go down the tree
        if (node.getData() > data) {
             node.setRight(insert(node.getRight(), data));//do insert on the right node
        } else {
            node.setLeft(insert(node.getLeft(), data));//do insert on the right node
        }
        return node;
    }
    
    public void insertData(int data) {
       root =  insert(root, data);
    }
    
    public void insert(int number) {
        if (root==null) {
            NodeObject newNode = new NodeObject();
            newNode.setData(number);
            root=newNode;
        }  
    }
 
    public void remove(int number) {
 
    }
 
    public boolean contains(int number) {
        return true;
    }
 }
