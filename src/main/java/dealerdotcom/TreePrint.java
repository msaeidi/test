package dealerdotcom;

import java.util.ArrayList;
import java.util.List;

public class TreePrint {

	public static void main(String[] args) {

		//forest
		//  x1
		//    x2
		//      x3
		//      x4
		//    x5
		treeNode root = new treeNode("forest", "");
		treeNode x1 = new treeNode("x1", "");
		root.addChild(x1);
		treeNode x2 = new treeNode("x2", "");
		x1.addChild(x2);
		treeNode x3 = new treeNode("x3", "");
		x2.addChild(x3);
		treeNode x4 = new treeNode("x4", "");
		x2.addChild(x4);
		treeNode x5 = new treeNode("x5", "");
		x1.addChild(x5);

		root.print();
		System.out.println();
		print(root);
		System.out.println();
		x1.print();
		System.out.println();
		print(x1);
	}
	
	public static void print(treeNode node) {
		print(node, 0);
	}
	
	public static void print(treeNode node, int level) {
	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; i < level; i++) {
	        buffer.append(".");
	    }
	    for (treeNode child: node.getChildren()) {
	        System.out.println(buffer.toString() + child.getLabel()+" : "+ child.getUrl());
	        print(child, level + 1);
	    }
	}

}

class treeNode {
	private String label;
	private String url;
    private List<treeNode> children = new ArrayList<treeNode>();

    public treeNode() {
    }
    
    public treeNode(String label, String url) {
    	this.label = label;
    	this.url = url;
    }
    
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<treeNode> getChildren() {
    	return children;
    }

    public void setChildren(List<treeNode> children) {
    	this.children = children;
    }

    public void addChild(treeNode child) {
    	children.add(child);
    }
    
	public void print() {
		print(0);
	}
	
	public void print(int level) {
	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; i < level; i++) {
	        buffer.append(".");
	    }
	    for (treeNode child: children) {
	        System.out.println(buffer.toString() + child.getLabel()+" : "+ child.getUrl());
	        child.print(level + 1);
	    }
	}

}