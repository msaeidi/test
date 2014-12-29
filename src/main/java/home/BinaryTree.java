package home;
//	http://cslibrary.stanford.edu/110/BinaryTrees.html#java
public class BinaryTree {

	// Root node pointer. Will be null for an empty tree.
	private Node root;

	private static class Node {
		Node left;
		Node right;
		int data;
	    Node(int newData) {
	    	left = null;
	    	right = null;
	    	data = newData;
	    }
	}

	public void BinaryTree() {
		root = null;
	}

	public boolean lookup(int data) {
		return(lookup(root, data));
	}

	private boolean lookup(Node node, int data) {
	    if (node==null) {
	    	return false;
	    } else if (data < node.data) {
	    	return lookup(node.left, data);
	    } else if (data > node.data) {
	    	return lookup(node.right, data);
	    } else {
	    	return true;
	    }
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node==null) {
			node = new Node(data);
	    } else {
	      if (data <= node.data) {
	    	  node.left = insert(node.left, data);
	      } else {
	    	  node.right = insert(node.right, data);
	      }
	    }
	    return node; // in any case, return the new pointer to the caller
	}
}
