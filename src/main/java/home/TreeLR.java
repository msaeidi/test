package home;

public class TreeLR {

    public static void main(String[] args) {
    	String path = "/home/sports/basketball/ncaa/";
    	if (path.startsWith("/")) {
    		path = path.substring(1);
    	}
    	String[] pathElem = path.split("/");
        Node root = new Node(pathElem[0]);
        insertNode(root, pathElem[0]);
        
//        new Tree().run();
    }

    static class Node {

        Node left;
        Node right;
        String value;

        public Node(String value) {
            this.value = value;
        }
    }
    
    public static void insertNode(Node node, String value) {
    	Node newNode = new Node(value);
    	node.right = newNode;
     }
/*
    public void run() {
        Node rootnode = new Node(pathElement[0]);
        System.out.println("Building tree with root value " + rootnode.value);
        System.out.println("=================================");
        insert(rootnode, 11);
        insert(rootnode, 15);
        insert(rootnode, 16);
        insert(rootnode, 23);
        insert(rootnode, 79);

    }
    

    public void insert(Node node, String value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of Node " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
            }
        }
    }
*/
}

