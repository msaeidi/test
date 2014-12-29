package home;

public class BinarySearchTreeApp {

    public static void main(String[] args) {
        //BinarySearchTree bst = new BinarySearchTree();
 
 //       System.out.println(bst.isEmpty());
       // bst.insert(10);
       // bst.insert(5);
       // bst.insert(3);
       // bst.insert(12);
       // bst.insert(14);
//        System.out.println(bst.isEmpty());
        //Node node = Search(bst, 14);
        //print(bst);
        //bst.getRoot().print();
        Node tree = new Node(10);
        tree.insert(14);
        tree.insert(5);
        tree.insert(3);
        tree.insert(12);
        tree.print();
        Node node = tree.Search(5);
        System.out.println();
        System.out.println("<< [" + node.getData() + "] <<");
//        System.out.println(node.getLeft().getData() + " << [" + node.getData() + "] << " + node.getRight().getData());
        System.out.println();
        node.print();
        System.out.println();
        tree.Search(10).print();
        System.out.println();
        tree.Search(14).print();
        System.out.println();
        tree.Search(5).print();
        System.out.println();
        tree.Search(3).print();
        System.out.println();
        tree.Search(12).print();
    }

    static void print(BinarySearchTree bst) {
    	Node root = bst.getRoot();
        print(root);
    }
    
    static void print(Node node) {
    	if(node==null) {
    		return;
    	}
    	print(node.getLeft());
    	System.out.print(node.getData());
    	print(node.getRight());
    }
}

class Node {
	
    private Node left;
    private Node right;
    private Node parent;
    private int data;
 
    public Node() {
    }
    
    public Node(int data) {
    	this.data = data;
    }

    public void print() {
    	if (left!=null) {
    		left.print();
    	}
    	System.out.print(data + "  <  ");
    	if (right!=null) {
    		right.print();
    	}
    }

    public Node Search(int data) {

        if (data < this.data) {
        	if (left != null) {
        		return left.Search(data);
        	} else {
        		return null;
        	}
        } else if (data > this.data) {
        	if (right != null) {
        		return right.Search(data);
        	} else {
        		return null;
        	}
        } else {
        	return this;
        }
    }

    public void insert(int data) {
        if (data < this.data) {
        	if (left!=null) {
        		left.insert(data);
        	} else { 
        		left = new Node(data);
         	}
        } else if (data > this.data) {
        	if (right!=null) {
        		right.insert(data);
        	} else { 
        		right = new Node(data);
        	}
        }
    }
    
    public Node insertAndReturn(int data) {
        if (data < this.data) {
        	if (left!=null) {
        		left.insert(data);
        	} else { 
        		left = new Node(data);
        		return left;
         	}
        } else if (data > this.data) {
        	if (right!=null) {
        		right.insert(data);
        	} else { 
        		right = new Node(data);
        		return right;
        	}
        }
        return this;
    }
    
    public void setLeft(Node left) {
        this.left=left;
    }
    public Node getLeft() {
        return left;
    }
 
    public void setRight(Node right) {
        this.right=right;
    }
 
    public Node getRight() {
        return right;
    }
 
    public void setParent(Node parent) {
        this.parent=parent;
    }
 
    public Node getParent() {
        return parent;
    }
 
    public void setData(int data) {
        this.data=data;
    }
 
    public int getData() {
        return data;
    }
}

class BinarySearchTree {

	private Node root;
    private Node parent;
    private Node node;
 
    public boolean isEmpty() {
        return root==null ;
    }
 
    private Node insert(Node node, int data) {
    	if (node==null) {
    		node = new Node();
    		node.setData(data);
    		return node;
    	}
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
            Node newNode = new Node();
            newNode.setData(number);
            root=newNode;
        }  
    }
 
    public void remove(int number) {
 
    }
 
    public boolean contains(int number) {
        return true;
    }
    
    public Node getRoot() {
    	return root;
    }
 
    Node Search(Node tree, int data) {
        if (tree == null) {
            return null;
        }
        int treeData = tree.getData();
        if (data < treeData) {
            return Search(tree.getLeft(), data);
        } else if (data > treeData) {
            return Search(tree.getRight(), data);
        } else {
        	return tree;
        }
    }
}