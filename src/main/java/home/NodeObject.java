package home;

public class NodeObject {
	
    private NodeObject left;      //left children
    private NodeObject right;     //right children
    private NodeObject parent;
    private int data;
 
    public void setLeft(NodeObject left) {
        this.left=left;
    }
    public NodeObject getLeft() {
        return left;
    }
 
    public void setRight(NodeObject right) {
        this.right=right;
    }
 
    public NodeObject getRight() {
        return right;
    }
 
    public void setParent(NodeObject parent) {
        this.parent=parent;
    }
 
    public NodeObject getParent() {
        return parent;
    }
 
    public void setData(int data) {
        this.data=data;
    }
 
    public int getData() {
        return data;
    }
}