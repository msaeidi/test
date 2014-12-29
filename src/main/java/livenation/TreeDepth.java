package livenation;

public class TreeDepth {

	public static void main(String[] args) {
		Node left = new Node(2);
		Node right = new Node(3);
		Node root = new Node(left, right, 1);
		left.left = new Node(4);
		right.left = new Node(5);
		right.left.right = new Node(6);
		System.out.println("dept: " + root.maxDepth(root));
		//System.out.println("dept: " + root.maxDepth());

	}
	
	static class Node {
		
		private Node left;
		
		private Node right;
		
		private int value;
		
		public Node() {}
		
		public Node(int value) {
			this.value=value;
		}
		
		public Node(Node left, Node right, int value) {
			this.left=left;
			this.right=right;
			this.value=value;
		}
		
		public static int maxDepth(Node node) {
			if (node == null) {
				return 0;
			}
			return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
		}

		public int maxDepth() {
			if (left == null) {
				if (right == null) {
					return 0;
				}
				return right.maxDepth();
			}
			if (right == null) {
				if (left == null) {
					return 0;
				}
				return left.maxDepth();
			}
			System.out.println(value);
			return Math.max(left.maxDepth(), right.maxDepth()) + 1;
		}
	}

}
