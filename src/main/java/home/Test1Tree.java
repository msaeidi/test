package home;
import java.util.ArrayList;
import java.util.List;

public class Test1Tree {
    private Node root;

    public Test1Tree(String path) {
    	String[] pathElems = getPathElems(path);
        Test1Tree.Node node = null;
        boolean first = true;
        for (String pathElem: pathElems) {
        	if (first) {
        		if (root==null) {
        			root = new Node(pathElem);
        		}
        		node = root;
        		first = false;
        	} else {
        		node = insertChild(node, pathElem);
        	}
        }
    }
    
    public void insertPath(String path) {
    	String[] pathElems = getPathElems(path);
        Test1Tree.Node node = root;
        boolean first = true;
        boolean found = false;
        for (String pathElem: pathElems) {
        	if (first) {
        		first = false;
        		continue;
        	}
    		for (Test1Tree.Node child : node.children) {
    			if (child.value.equals(pathElem)) {
    				node = child;
    				found = true;
    				break;
    			}
    		}
            if (!found) {
            	node = insertChild(node, pathElem);
           }
        }
    }

    public class Node {
        private String value;
        private List<Node> children;
        public Node(String value) {
        	this.value = value;
        	this.children = new ArrayList<Node>();
        }
        
        public Node(String value, List<Node> children) {
        	this.value = value;
        	this.children = children;
        }
    }
    
    public void insertChild(Node node, Node child) {
    	node.children.add(child);
    }

    public Node insertChild(Node node, String childValue) {
    	Node child = new Node(childValue);
    	node.children.add(child);
    	return child;
    }

//    public void removeChild(Node node, Node child) {
//    	if (node.children.contains(child)) {
//    		node.children.remove(child);
//    	}
//    }
    
	private String[] getPathElems(String path) {
    	if (path.startsWith("/")) {
    		path = path.substring(1);
    	}
    	return path.split("/");
    }

	public void printTree() {
		System.out.println("Printing Tree: ");
		printNode(root);
	}

	private void printNode(Node node) {
		System.out.println(node.value);
		for (Node child : node.children) {
			printNode(child);
		}

	}
}
