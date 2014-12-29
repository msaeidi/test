package home;
//Binary Search tree
public class BinarySearchNodeTree {

    public static void main(String[] args) {
    	SearchTreeNode tree = new SearchTreeNode(10);
        tree.insert(14);
        tree.insert(17);
        tree.insert(18);
        tree.insert(5);
        tree.insert(6);
        tree.insert(6);
        tree.insert(4);
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(12);
        tree.insert(13);
        tree.insert(16);
        tree.insert(15);
        tree.print();
        System.out.println();

        System.out.println();
        System.out.println(total(tree));
        System.out.println(sum(tree));
        System.out.println(10+5+4+3+1+2+6+14+12+13+17+16+15+18);

        //SearchTreeNode node = closestNode(tree, 11);
        //System.out.println(node.getData());
        
    	SearchTreeNode tree1 = new SearchTreeNode(32);
        tree1.insert(24);
        tree1.insert(24);
        tree1.insert(21);
        tree1.insert(28);
        tree1.insert(14);
        tree1.insert(25);
        tree1.insert(31);
        tree1.insert(41);
        tree1.insert(36);
        tree1.insert(47);
        tree1.insert(39);

        SearchTreeNode node = closestNode(tree1, 29);
        System.out.println(node.getData());

        SearchTreeNode node1 = closestNode1(tree1, 29);
        System.out.println(node1.getData());

        SearchTreeNode node2 = nearestNode(tree1, 29, tree1);
        System.out.println(node2.getData());
        /*
        TreeNode node = tree.Search(5);
        System.out.println();
        System.out.println("<< [" + node.getData() + "] <<");
//        System.out.println(node.getLeft().getData() + " << [" + node.getData() + "] << " + node.getRight().getData());
        System.out.println();
        node.print();
        System.out.println();
        tree.search(10).print();
        System.out.println();
        tree.search(14).print();
        System.out.println();
        tree.search(5).print();
        System.out.println();
        tree.search(3).print();
        System.out.println();
        tree.search(12).print();
        System.out.println();
        System.out.println(tree.search(12).getParent().getData());
        System.out.println(tree.isSorted());
        */
        tree.remove(14);
        tree.print();
        tree.insert(4);
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(12);
        tree.insert(13);
        tree.insert(16);
        tree.insert(15);

    }
    
    public static int total(SearchTreeNode tree) {
    	return tree.sum(0);
    }

    public static int sum(SearchTreeNode tree) {
    	return sum(tree, 0);
    }

    public static int sum(SearchTreeNode tree, int tot) {
    	int total = tot + tree.getData();
    	if (tree.getLeft()!=null) {
    		total = sum(tree.getLeft(), total);
    	}
    	if (tree.getRight()!=null) {
    		total = sum(tree.getRight(), total);
    	}
    	return total;
    }

    public static SearchTreeNode closestNode(SearchTreeNode tree, int value) {
    	SearchTreeNode node = tree;
    	SearchTreeNode closest = null;
    	int min = Integer.MAX_VALUE;
    	while (node != null) {
    		int distance = Math.abs(node.getData() - value);
    		if (distance < min) {
    			min = distance;
    			closest = node;
    		}
    		if (node.getData() > value) {
    			node = node.getLeft();
    		} else if (node.getData() < value) {
    			node = node.getRight();
    		} else { //node.getData() == value
    			break;
    		}
    	}
        return closest;
    }
    
    public static SearchTreeNode closestNode1(SearchTreeNode tree, int value) {
    	SearchTreeNode closest = tree;
    	SearchTreeNode node = tree;
    	while (node != null) {
    		int distance = Math.abs(node.getData() - value);
    		if (distance < Math.abs(closest.getData() - value)) {
    			closest = node;
    		}
    		if (node.getData() > value) {
    			node = node.getLeft();
    		} else if (node.getData() < value) {
    			node = node.getRight();
    		} else { //node.getData() == value
    			break;
    		}
    	}
        return closest;
    }

    public static SearchTreeNode nearestNode(SearchTreeNode node, int value, SearchTreeNode nearest) {
    	if (node != null) {
    		int data = node.getData();
    		int interval = Math.abs(data - value);
    		if (interval < Math.abs(nearest.getData() - value)) {
    			nearest = node;
    		}
    		if (data > value) {
    			return nearestNode(node.getLeft(), value, nearest);
    		} else if (data < value) {
    			return nearestNode(node.getRight(), value, nearest);
    		}
    	}
        return nearest;
    }

/*
    public static SearchTreeNode closestNode2(SearchTreeNode tree, int value, int min) {
    	SearchTreeNode node = tree;
    	SearchTreeNode closest = tree;
    	//int min = Math.abs(tree.getData() - value);
    	while (node != null) {
    		int distance = Math.abs(node.getData() - value);
    		int min =  Math.abs(closest.getData() - value);
    		if (distance < min) {
    			//min = distance;
    			closest = node;
    		}
    		if (node.getData() > value) {
    			return closestNode2(node.getLeft(), value);
    		} else if (node.getData() < value) {
    			return closestNode2(node.getRight(), value);
    		}
    	}
        return closest;
    }
*/
    public static SearchTreeNode nearestNode(SearchTreeNode node, int value) {
        if (node.getData() > value) {
        	if (node.getLeft() != null) {
        		return closestNode(node.getLeft(), value);
        	} else {
        		return null;
        	}
        } else if (node.getData() < value) {
        	if (node.getRight() != null) {
        		return closestNode(node.getRight(), value);
        	} else {
        		return null;
        	}
        } else {
        	return node;
        }
    }

}

class SearchTreeNode {
	
    private SearchTreeNode left;
    private SearchTreeNode right;
    private SearchTreeNode parent;
    private int data;
 
    public SearchTreeNode() {
    }
    
    public SearchTreeNode(int data) {
    	this.data = data;
    }
    
    public int sum(int tot) {
    	int total = tot + data;
    	if (left!=null) {
    		total = left.sum(total);
    	}
    	if (right!=null) {
    		total = right.sum(total);
    	}
    	return total;
    }

    public void print() {
    	if (left!=null) {
    		left.print();
    	}
    	System.out.print("[ " + (left!=null ? left.data : "null") + " : " + data + " : " + (right!=null ? right.data : "null") + "]  <  ");
    	if (right!=null) {
    		right.print();
    	}
    }

    public SearchTreeNode search(int data) {
        if (data < this.data) {
        	if (left != null) {
        		return left.search(data);
        	} else {
        		return null;
        	}
        } else if (data > this.data) {
        	if (right != null) {
        		return right.search(data);
        	} else {
        		return null;
        	}
        } else {
        	return this;
        }
    }

    public boolean insert(int data) {
        if (data < this.data) {
        	if (left!=null) {
        		return left.insert(data);
        	} else { 
        		left = new SearchTreeNode(data);
        		left.parent = this;
        		return true;
         	}
        } else if (data > this.data) {
        	if (right!=null) {
        		return right.insert(data);
        	} else { 
        		right = new SearchTreeNode(data);
        		right.parent = this;
        		return true;
        	}
        } else {
        	return false;
        }
    }
    
    public boolean isSorted() {
     	if (left!=null) {
     		if (left.data > data || !left.isSorted()) {
     			return false;
     		}
    	}
     	if (right!=null) { 
     		if (right.data < data || !right.isSorted()) {
     			return false;
     		}
    	}
     	return true;
    }
    
    public boolean isOrdered() {
     	if (left!=null && (left.data > data || !left.isOrdered())) {
     		return false;
    	} else if (right!=null && (right.data < data || !right.isOrdered())) {
     		return false;
    	}
     	return true;
    }

    public SearchTreeNode find(int data) {
        if (data < this.data && left != null) {
        	return left.find(data);
        } else if (data > this.data && right != null) {
        	return right.find(data);
        } else if (data == this.data) {
        	return this;
        }
		return null;
    }

    public boolean remove(int data) {
        if (data < this.data) {
        	if (left!=null) {
        		return left.remove(data);
        	} else {
        		return false;
         	}
        } else if (data > this.data) {
        	if (right!=null) {
        		return right.remove(data);
        	} else { 
        		return false;
        	}
        } else {//found  data == this.data
        	if (left!=null && right!=null) {//keep and move left tree and right tree
        		SearchTreeNode node;
    			int leftRightNullDepth = left.getLevelWithNullRight();
    			int rightLeftNullDepth = right.getLevelWithNullLeft();
    			System.out.println("leftRightNullDepth: " + leftRightNullDepth);
    			System.out.println("rightLeftNullDepth: " + rightLeftNullDepth);
    			if (leftRightNullDepth < rightLeftNullDepth) {
    				node = left.getNodeWithNullRight();
    				node.right = right;
    				right.parent = node;
    				left.parent = parent;
        			if (parent.left==null && parent.left.data==data) {
        				parent.left = left;
        			} else if (parent.right!=null && parent.right.data==data) { 
        				parent.right = left;
        			}
    			} else {
    				node = right.getNodeWithNullLeft();
        			node.left = left;
        			left.parent = node;
    				right.parent = parent;
    				
        			if (parent.left==null && parent.left.data==data) {
        				parent.left = right;
        			} else if (parent.right!=null && parent.right.data==data) { 
        				parent.right = right;
        			}
    			}
    			return true;
        	} else if (left==null || right==null) {
        		SearchTreeNode node = left != null ? left : right;
        		if (parent.left==null && parent.left.data==data) {
        			parent.left = node;
        		} else if (parent.right!=null && parent.right.data==data) {
        			parent.right = node;
        		}
        		if (node!=null) {
        			node.parent = parent;
        		}
       			return true;
        	}
        	return false;
        }
    }
    
    public SearchTreeNode getNodeWithNullRight() {
    	if (right==null) {
    		return this;
    	} else {
    		return right.getNodeWithNullRight();
    	}
    }
    
    public SearchTreeNode getNodeWithNullLeft() {
    	if (right==null) {
    		return this;
    	} else {
    		return right.getNodeWithNullLeft();
    	}
    }
    
    public int getLevelWithNullRight() {
    	if (right==null) {
    		return 1;
    	} else {
    		return 1 + right.getLevelWithNullRight();
    	}
    }

    public int getLevelWithNullLeft() {
    	if (left==null) {
    		return 1;
    	} else {
    		return 1 + left.getLevelWithNullLeft();
    	}
    }

    public void remove() {
    	
    	if (parent.left!=null && this == parent.left) {
    		parent.left = null;
    		//this=null;
    	} else if (parent.right!=null && this == parent.right) {
    		parent.right = null;
    	}
   	
    }
    
    public SearchTreeNode addAndReturnIt(int data) {
        if (data < this.data) {
        	if (left!=null) {
        		left.insert(data);
        	} else { 
        		left = new SearchTreeNode(data);
            	left.parent = this;
        		return left;
         	}
        } else if (data > this.data) {
        	if (right!=null) {
        		right.insert(data);
        	} else { 
        		right = new SearchTreeNode(data);
            	right.parent = this;
        		return right;
        	}
        }
        return this;
    }
    
    public void setLeft(SearchTreeNode left) {
        this.left=left;
    }
    public SearchTreeNode getLeft() {
        return left;
    }
 
    public void setRight(SearchTreeNode right) {
        this.right=right;
    }
 
    public SearchTreeNode getRight() {
        return right;
    }
 
    public void setParent(SearchTreeNode parent) {
        this.parent=parent;
    }
 
    public SearchTreeNode getParent() {
        return parent;
    }
 
    public void setData(int data) {
        this.data=data;
    }
 
    public int getData() {
        return data;
    }
}

//public boolean remove(int data) {
//    if (data < this.data) {
//    	if (left!=null) {
//    		return left.remove(data);
//    	} else {
//    		return false;
//     	}
//    } else if (data > this.data) {
//    	if (right!=null) {
//    		return right.remove(data);
//    	} else { 
//    		return false;
//    	}
//    } else {//found  data == this.data
//    	if (left!=null && right!=null) {//keep and move left tree and right tree
//
////    		if (right.left==null) {
////    			right.left = left;
////				right.parent = parent;
////    			left.parent = right;
////    			if (parent.left==null && parent.left.data==data) {
////    				parent.left = right;
////    			} else if (parent.right!=null && parent.right.data==data) { 
////    				parent.right = right;
////    			}
////    			return true;
////    		} else if (left.right==null) {
////				left.right = right;
////				left.parent = parent;
////				right.parent = left;
////    			if (parent.left==null && parent.left.data==data) {
////    				parent.left = left;
////    			} else if (parent.right!=null && parent.right.data==data) { 
////    				parent.right = left;
////    			}
////    			return true;
////    		} else {
//    		
//    			TreeNode node;
//    			int leftRightNullDepth = left.getLevelWithNullRight();
//    			int rightLeftNullDepth = right.getLevelWithNullLeft();
//    			System.out.println("leftRightNullDepth: " + leftRightNullDepth);
//    			System.out.println("rightLeftNullDepth: " + rightLeftNullDepth);
//    			if (leftRightNullDepth < rightLeftNullDepth) {
//    				node = left.getNodeWithNullRight();
//    				node.right = right;
//    				right.parent = node;
//    				left.parent = parent;
//        			if (parent.left==null && parent.left.data==data) {
//        				parent.left = left;
//        			} else if (parent.right!=null && parent.right.data==data) { 
//        				parent.right = left;
//        			}
//    			} else {
//    				node = right.getNodeWithNullLeft();
//        			node.left = left;
//        			left.parent = node;
//    				right.parent = parent;
//    				
//        			if (parent.left==null && parent.left.data==data) {
//        				parent.left = right;
//        			} else if (parent.right!=null && parent.right.data==data) { 
//        				parent.right = right;
//        			}
//    			}
//    			return true;
////    		}
//    	
//    	
////    	} else if (left!=null && right==null) {
////    		if (parent.left!=null && parent.left.data==data) {//deleting node is on the left side of parent
////    			parent.left = left;
////    		} else if (parent.right!=null && parent.right.data==data) {//deleting node is on the right side of parent
////    			parent.right = left;
////    		}
////			left.parent = parent;
////   			return true;
////    	} else if (left==null && right!=null) {
////    		if (parent.left!=null && parent.left.data==data) {//deleting node is on the left side of parent
////    			parent.left = right;
////    		} else if (parent.right!=null && parent.right.data==data) {//deleting node is on the right side of parent
////    			parent.right = right;
////    		} 
////			right.parent = parent;
////   			return true;
////    	} else if (left==null && right==null) {
////    		if (parent.left!=null && parent.left.data==data) {//deleting node is on the left side of parent
////    			parent.left = null;
////    		} else if (parent.right!=null && parent.right.data==data) {//deleting node is on the right side of parent
////    			parent.right = null;
////    		} 
////   			return true;
//    	} else if (left==null || right==null) {
//    		TreeNode node = left != null ? left : right;
//    		if (parent.left==null && parent.left.data==data) {
//    			parent.left = node;
//    		} else if (parent.right!=null && parent.right.data==data) {
//    			parent.right = node;
//    		}
//    		if (node!=null) {
//    			node.parent = parent;
//    		}
//   			return true;
//    	}
//    	return false;
//    }
//}
