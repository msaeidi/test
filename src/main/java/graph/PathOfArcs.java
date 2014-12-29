package graph;

import graph.GraphShortest.Arc;

import java.util.ArrayList;
import java.util.List;

public class PathOfArcs {

	private List<Arc> arcs = new ArrayList<Arc>();
	private int value = 0;
	
	public PathOfArcs() {}
	
	public PathOfArcs(PathOfArcs path, Arc arc, int value) {
		//this.path.
		this.arcs.add(arc);
		this.value += value;
	}
	
	public List<Arc> getArcs() {
		return arcs;
	}

	public void setArcs(List<Arc> arcs) {
		this.arcs = arcs;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


//	static List<Arc> shortestPath(Node start, Node end, Graph g) {
//		//recursively find arcs leaving from a given node and loop in them and add value to the shortest between the end node of each arc
//		//List<Arc> path = new ArrayList<Arc>();
//		//get arcs leaving from a node start
//		//Set<Arc> arcs = g.arcs;
//		//for (Node n:)
//		//return min(shortestPath(from, to)).add(arc1);
//		start.setVisited(true);
//		Set<Arc> leavingArcs = g.getUnvisitedNodeArcs(start);
//		int min = Integer.MAX_VALUE;
//		Arc minArc;
//		for (Arc arc: leavingArcs) {
//			int val = arc.getValue() + shortestPath(arc.getTo(), end , g);
//			if (val < min) {
//				min = val;
//				minArc = arc;
//			}
//		}
//		return path;
//	}
	

}
