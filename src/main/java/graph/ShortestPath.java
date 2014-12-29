package graph;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.junit.Test;


public class ShortestPath {
//assume vertices are labeled positive integer number from 1 to n
//define Arc as a directed line from a vertex to the other vertex and we are assuming unique arc between unique vertices
	//private static final Map<Table, Set<Table>> parentTablesMap = new HashMap<Table, Set<Table>>();
	//private static final Map<Table, Set<Table>> childTablesMap = new HashMap<Table, Set<Table>>();

	public static void main(String[] args) {
/*
		test7();
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
*/		
		HRtables();
	}
	static Solution shortestPath(Set<Arc> arcs, Node source, Node target, String graph) {
		Set<Node> nodes = new HashSet<Node>();
		for (Arc arc : arcs) {
			nodes.add(arc.from());
			nodes.add(arc.to());
		}
		int size = nodes.size();
		Map<Node, Integer> dist = new HashMap<Node, Integer>();
		Map<Node, Arc> pred = new HashMap<Node, Arc>();
		for (Node node: nodes) {
			dist.put(node, null);
		}
		dist.put(source, 0);
		
		for (int i = 0; i < size; i++) {
			for (Node node: nodes) {
				for (Arc arc : getArcsFrom(arcs, node))	{
					Node to = arc.to();
					if (dist.get(node)==null)continue;
					int minValue = dist.get(node) + arc.value();
					if (dist.get(to)==null || dist.get(to) > minValue)	{
						dist.put(to, minValue);
						pred.put(to, arc);
					}
				}		
			}
		}
		Node node = target;
		List<Arc> path = new ArrayList<Arc>();
		for (int i=0; i<pred.size(); i++) {
			Arc arc = pred.get(node);
			path.add(0, arc);
			node = arc.from();
			if (node.equals(source)) break;
		}

		System.out.println("======================================================================= " + graph + " ========================================================================");
		System.out.println("Shortest Path [" + source + "," + target + "]: " + Arrays.asList(path) + " with value: " + dist.get(target));
		System.out.println();
		System.out.println(Arrays.asList(dist));
		System.out.println(Arrays.asList(pred));
		System.out.println();
		return new Solution(dist, pred, path);
	}
	static Set<Arc> getArcsFrom(Set<Arc> arcs, Node from) {
		Set<Arc> arcsFrom = new HashSet<Arc>();
		for (Arc arc : arcs) {
			if (arc.from()==from) {
				arcsFrom.add(arc);
			}
			

//undirected graph			
			if (arc.to()==from) {
				arcsFrom.add(arc);
			}

		
		}
		return arcsFrom;
	}
	static class Solution {
		private Map<Node, Integer> dist;
		private Map<Node, Arc> pred;
		private List<Arc> path;
		public Solution(Map<Node, Integer> dist, Map<Node, Arc> pred, List<Arc> path) {
			super();
			this.dist = dist;
			this.pred = pred;
			this.path = path;
		}
		public Map<Node, Integer> getDist() {
			return dist;
		}
		public void setDist(Map<Node, Integer> dist) {
			this.dist = dist;
		}
		public Map<Node, Arc> getPred() {
			return pred;
		}
		public void setPred(Map<Node, Arc> pred) {
			this.pred = pred;
		}
		public List<Arc> getPath() {
			return path;
		}
		public void setPath(List<Arc> path) {
			this.path = path;
		} 
	}

	static class Arc {
		private Node from;
		private Node to;
		private int value;
		public Arc(Node from, Node to) {
			this.from=from;
			this.to=to;
			this.value=1;
		}
		public Arc(Node from, Node to, int value) {
			this.from=from;
			this.to=to;
			this.value=value;
		}
		public Node from() {
			return from;
		}
		public Node to() {
			return to;
		}
		public int value() {
			return value;
		}
		@Override
		public String toString() {
			return "Arc[" + value + ": " + from + " to " + to + "]";
		}
	}
	
	static class Node {
		private String label;
		public Node(String label) {
			this.label=label;
		}
		public String getLabel() {
			return label;
		}
		@Override
		public String toString() {
			return label;
		}
	}

	static void test7() {
		//http://www.cs.princeton.edu/~rs/AlgsDS07/15ShortestPaths.pdf
		Node s = new Node("s");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		Node n5 = new Node("5");
		Node n6 = new Node("6");
		Node n7 = new Node("7");
		Node t = new Node("t");
		Set<Arc> arcs = new HashSet<Arc>();
		arcs.add(new Arc(s, n2,  9)); //*
		arcs.add(new Arc(s, n6, 14));
		arcs.add(new Arc(s, n7, 15));
		arcs.add(new Arc(n2, n3, 24)); //*
		arcs.add(new Arc(n7, t, 44));
		arcs.add(new Arc(n6, n3, 18));
		arcs.add(new Arc(n6, n5, 30));
		arcs.add(new Arc(n6, n7,  5));
		arcs.add(new Arc(n5, n4, 11));
		arcs.add(new Arc(n5, t, 16));
		arcs.add(new Arc(n3, n5,  2));
		arcs.add(new Arc(n3, t, 19));
		arcs.add(new Arc(n4, n3, 45));
		arcs.add(new Arc(n4, t,  6));
		
		Solution sol = shortestPath(arcs, s, t, "test7");
		//System.out.println(Arrays.asList(sol.getDist()));
		//System.out.println(Arrays.asList(sol.getPred()));
		//System.out.println("Path: " + Arrays.asList(sol.getPath()));
		
		//Shortest Path [s,t]: [[Arc[14: s to 6], Arc[18: 6 to 3], Arc[2: 3 to 5], Arc[16: 5 to t]]] with value: 50
		//[{t=50, s=0, 5=34, 2=9, 6=14, 4=45, 7=15, 3=32}]
		//[{t=Arc[16: 5 to t], 5=Arc[2: 3 to 5], 2=Arc[9: s to 2], 4=Arc[11: 5 to 4], 6=Arc[14: s to 6], 7=Arc[15: s to 7], 3=Arc[18: 6 to 3]}]

	}
	
	static void HRtables() {
		Set<Node> nodes = new HashSet<Node>();
		Node REGIONS = new Node("REGIONS");
		Node COUNTRIES = new Node("COUNTRIES");
		Node LOCATIONS = new Node("LOCATIONS");
		Node DEPARTMENTS = new Node("DEPARTMENTS");
		Node EMPLOYEES = new Node("EMPLOYEES");
		Node JOBS = new Node("JOBS");
		Node JOB_HISTORY = new Node("JOB_HISTORY");
		Set<Arc> arcs = new HashSet<Arc>();
		arcs.add(new Arc(REGIONS, COUNTRIES, 1));
		arcs.add(new Arc(COUNTRIES, REGIONS, 1));
		arcs.add(new Arc(COUNTRIES, LOCATIONS, 1));
		arcs.add(new Arc(LOCATIONS, COUNTRIES, 1));
		arcs.add(new Arc(LOCATIONS, DEPARTMENTS, 1));
		arcs.add(new Arc(DEPARTMENTS, LOCATIONS, 1));
		arcs.add(new Arc(DEPARTMENTS, EMPLOYEES, 1));
		arcs.add(new Arc(EMPLOYEES, LOCATIONS, 1));
		arcs.add(new Arc(EMPLOYEES, JOB_HISTORY, 1));
		arcs.add(new Arc(JOB_HISTORY, EMPLOYEES, 1));
		arcs.add(new Arc(JOB_HISTORY, JOBS, 1));
		arcs.add(new Arc(JOBS, JOB_HISTORY, 1));
		
		//System.out.println("------------- test1 ---------------");
		Solution sol = shortestPath(arcs, COUNTRIES, JOB_HISTORY, "HR Tables");
		sol = shortestPath(arcs, COUNTRIES, JOBS, "HR Tables");
//		System.out.println("Path: " + Arrays.asList(sol.getPath()));
//		System.out.println();
//		System.out.println(Arrays.asList(sol.getDist()));
//		System.out.println(Arrays.asList(sol.getPred()));
//		System.out.println("------------------------------------");
	}

	static void test1() {
		Set<Node> nodes = new HashSet<Node>();
		Node n1 = new Node("one");
		nodes.add(n1);
		Node n2 = new Node("two");
		nodes.add(n2);
		Node n3 = new Node("three");
		nodes.add(n3);
		Node n4 = new Node("four");
		nodes.add(n4);
		Node n5 = new Node("five");
		nodes.add(n5);
		Node n6 = new Node("six");
		nodes.add(n6);
		Node n7 = new Node("seven");
		nodes.add(n7);
		Set<Arc> arcs = new HashSet<Arc>();
		arcs.add(new Arc(n1, n2, 1));
		arcs.add(new Arc(n1, n3, 1));
		arcs.add(new Arc(n2, n4, 1));
		arcs.add(new Arc(n2, n7, 1));
		arcs.add(new Arc(n3, n4, 1));
		arcs.add(new Arc(n4, n7, 1));
		
		//System.out.println("------------- test1 ---------------");
		Solution sol = shortestPath(arcs, n1, n7, "test1");
//		System.out.println("Path: " + Arrays.asList(sol.getPath()));
//		System.out.println();
//		System.out.println(Arrays.asList(sol.getDist()));
//		System.out.println(Arrays.asList(sol.getPred()));
//		System.out.println("------------------------------------");
	}

	static void test2() {
		Set<Node> nodes = new HashSet<Node>();
		Node n1 = new Node("one");
		nodes.add(n1);
		Node n2 = new Node("two");
		nodes.add(n2);
		Node n3 = new Node("three");
		nodes.add(n3);
		Node n4 = new Node("four");
		nodes.add(n4);
		Node n5 = new Node("five");
		nodes.add(n5);
		Node n6 = new Node("six");
		nodes.add(n6);
		Node n7 = new Node("seven");
		nodes.add(n7);
		Set<Arc> arcs = new HashSet<Arc>();
		arcs.add(new Arc(n1, n2, 3));
		arcs.add(new Arc(n1, n3, 1));
		arcs.add(new Arc(n2, n4, 1));
		arcs.add(new Arc(n2, n7, 1));
		arcs.add(new Arc(n3, n4, 1));
		arcs.add(new Arc(n4, n7, 1));
		Solution sol = shortestPath(arcs, n1, n7, "test2");
	}
	static void test3() {
		Set<Node> nodes = new HashSet<Node>();
		Node n1 = new Node("one");
		nodes.add(n1);
		Node n2 = new Node("two");
		nodes.add(n2);
		Node n3 = new Node("three");
		nodes.add(n3);
		Node n4 = new Node("four");
		nodes.add(n4);
		Node n5 = new Node("five");
		nodes.add(n5);
		Node n6 = new Node("six");
		nodes.add(n6);
		Node n7 = new Node("seven");
		nodes.add(n7);
		Set<Arc>arcs = new HashSet<Arc>();
		arcs.add(new Arc(n1, n2, 5));
		arcs.add(new Arc(n1, n3, 8));
		arcs.add(new Arc(n1, n5, 7));
		arcs.add(new Arc(n1, n6, 10));
		arcs.add(new Arc(n2, n3, 1));
		arcs.add(new Arc(n2, n5, 3));
		arcs.add(new Arc(n5, n4, 4));
		arcs.add(new Arc(n5, n7, 7));
		arcs.add(new Arc(n5, n6, 2));
		arcs.add(new Arc(n6, n7, 3));
		arcs.add(new Arc(n3, n4, 6));
		arcs.add(new Arc(n7, n3, 4));
		arcs.add(new Arc(n7, n4, 5));
		Solution sol = shortestPath(arcs, n1, n4, "test3");
		//runFor("3", arcs, nodes, n1, n4, 11);
	}
	static void test4() {
		Set<Node> nodes = new HashSet<Node>();
		Node s = new Node("s");
		nodes.add(s);
		Node a = new Node("a");
		nodes.add(a);
		Node b = new Node("b");
		nodes.add(b);
		Node c = new Node("c");
		nodes.add(c);
		Node d = new Node("d");
		nodes.add(d);
		Node e = new Node("e");
		nodes.add(e);
		Node f = new Node("f");
		nodes.add(f);
		Node g = new Node("g");
		nodes.add(g);
		Node t = new Node("t");
		nodes.add(t);
		Set<Arc> arcs = new HashSet<Arc>();
		arcs.add(new Arc(s, a, 1));
		arcs.add(new Arc(s, b, 9));
		arcs.add(new Arc(a, c, 3));
		arcs.add(new Arc(a, d, 1));
		arcs.add(new Arc(b, d, 1));
		arcs.add(new Arc(b, e, 2));
		arcs.add(new Arc(c, f, 2));
		arcs.add(new Arc(d, f, 7));
		arcs.add(new Arc(d, g, 8));
		arcs.add(new Arc(e, g, 3));
		arcs.add(new Arc(f, t, 5));
		arcs.add(new Arc(g, t, 2));
		Solution sol = shortestPath(arcs, s, t, "test4");
		//runFor("4", arcs, nodes, s, t, 11);
	}
	static void test5() {
		Set<Node> nodes = new HashSet<Node>();
		Node a = new Node("a");
		nodes.add(a);
		Node b = new Node("b");
		nodes.add(b);
		Node c = new Node("c");
		nodes.add(c);
		Node d = new Node("d");
		nodes.add(d);
		Node e = new Node("e");
		nodes.add(e);
		Node f = new Node("f");
		nodes.add(f);
		Node g = new Node("g");
		nodes.add(g);
		Node t = new Node("t");
		nodes.add(t);
		Node h = new Node("h");
		nodes.add(h);
		Node i = new Node("i");
		nodes.add(i);
		Node j = new Node("j");
		nodes.add(j);
		Node k = new Node("k");
		nodes.add(k);
		Node l = new Node("l");
		nodes.add(l);
		Node m = new Node("m");
		nodes.add(m);
		Node n = new Node("n");
		nodes.add(n);
		Node o = new Node("o");
		nodes.add(o);
		Node p = new Node("p");
		nodes.add(p);
		Node q = new Node("q");
		nodes.add(q);
		Node r = new Node("r");
		nodes.add(r);
		Node s = new Node("s");
		nodes.add(s);
		Node z = new Node("z");
		nodes.add(z);
		Set<Arc> arcs = new HashSet<Arc>();
		arcs.add(new Arc(a, b, 2));
		arcs.add(new Arc(a, c, 4));
		arcs.add(new Arc(a, d, 1));
		arcs.add(new Arc(b, e, 1));
		arcs.add(new Arc(b, c, 3));
		arcs.add(new Arc(c, e, 2));
		arcs.add(new Arc(c, f, 2));
		arcs.add(new Arc(d, f, 5));
		arcs.add(new Arc(d, g, 4));
		arcs.add(new Arc(e, h, 3));
		arcs.add(new Arc(f, h, 3));
		arcs.add(new Arc(f, i, 2));
		arcs.add(new Arc(f, j, 4));
		arcs.add(new Arc(g, f, 3));
		arcs.add(new Arc(g, k, 2));
		arcs.add(new Arc(h, o, 8));
		arcs.add(new Arc(h, l, 1));
		arcs.add(new Arc(i, l, 3));
		arcs.add(new Arc(i, m, 2));
		arcs.add(new Arc(i, j, 3));
		arcs.add(new Arc(j, m, 6));
		arcs.add(new Arc(j, n, 3));
		arcs.add(new Arc(j, k, 6));
		arcs.add(new Arc(k, n, 4));
		arcs.add(new Arc(k, r, 2));
		arcs.add(new Arc(l, o, 6));
		arcs.add(new Arc(m, l, 3));
		arcs.add(new Arc(m, o, 4));
		arcs.add(new Arc(m, p, 2));
		arcs.add(new Arc(m, n, 5));
		arcs.add(new Arc(n, q, 2));
		arcs.add(new Arc(o, s, 6));
		arcs.add(new Arc(o, p, 2));
		arcs.add(new Arc(p, s, 2));
		arcs.add(new Arc(p, t, 1));
		arcs.add(new Arc(q, p, 1));
		arcs.add(new Arc(q, t, 3));
		arcs.add(new Arc(r, q, 8));
		arcs.add(new Arc(r, n, 1));
		arcs.add(new Arc(r, t, 5));
		arcs.add(new Arc(s, z, 2));
		arcs.add(new Arc(t, z, 8));
		Solution sol = shortestPath(arcs, a, z, "test5");
		//runFor("5", arcs, nodes, a, z, 16);
	}
	static void test6() {
		Set<Node> nodes = new HashSet<Node>();
		Node s = new Node("s");
		nodes.add(s);
		Node a = new Node("a");
		nodes.add(a);
		Node b = new Node("b");
		nodes.add(b);
		Node c = new Node("c");
		nodes.add(c);
		Node d = new Node("d");
		nodes.add(d);
		Node e = new Node("e");
		nodes.add(e);
		Node f = new Node("f");
		nodes.add(f);
		Node g = new Node("g");
		nodes.add(g);
		Node t = new Node("t");
		nodes.add(t);
		Node h = new Node("h");
		nodes.add(h);
		Node i = new Node("i");
		nodes.add(i);
		Node j = new Node("j");
		nodes.add(j);
		Node k = new Node("k");
		nodes.add(k);
		Node l = new Node("l");
		nodes.add(l);
		Node m = new Node("m");
		nodes.add(m);
		Node n = new Node("n");
		nodes.add(n);
		Node o = new Node("o");
		nodes.add(o);
		Node p = new Node("p");
		nodes.add(p);
		Node q = new Node("q");
		nodes.add(q);
		Node r = new Node("r");
		nodes.add(r);
		Node z = new Node("z");
		nodes.add(z);
		Set<Arc> arcs = new HashSet<Arc>();
		arcs.add(new Arc(a, b, 2));
		arcs.add(new Arc(a, c, 4));
		arcs.add(new Arc(a, d, 1));
		arcs.add(new Arc(b, e, 1));
		arcs.add(new Arc(b, c, 3));
		arcs.add(new Arc(c, e, 2));
		arcs.add(new Arc(c, f, 2));
		arcs.add(new Arc(d, f, 5));
		arcs.add(new Arc(d, g, 4));
		arcs.add(new Arc(e, h, 3));
		arcs.add(new Arc(f, h, 3));
		arcs.add(new Arc(f, i, 2));
		arcs.add(new Arc(f, j, 4));
		arcs.add(new Arc(g, f, 3));
		arcs.add(new Arc(g, k, 2));
		arcs.add(new Arc(h, o, 8));
		arcs.add(new Arc(h, l, 1));
		arcs.add(new Arc(i, l, 3));
		arcs.add(new Arc(i, m, 2));
		arcs.add(new Arc(i, j, 3));
		arcs.add(new Arc(j, m, 6));
		arcs.add(new Arc(j, n, 3));
		arcs.add(new Arc(j, k, 6));
		arcs.add(new Arc(k, n, 4));
		arcs.add(new Arc(k, r, 2));
		arcs.add(new Arc(l, o, 6));
		arcs.add(new Arc(m, l, 3));
		arcs.add(new Arc(m, o, 4));
		arcs.add(new Arc(m, p, 2));
		arcs.add(new Arc(m, n, 5));
		arcs.add(new Arc(n, q, 2));
		arcs.add(new Arc(o, s, 6));
		arcs.add(new Arc(o, p, 2));
		arcs.add(new Arc(p, s, 2));
		arcs.add(new Arc(p, t, 1));
		arcs.add(new Arc(q, p, 1));
		arcs.add(new Arc(q, t, 3));
		arcs.add(new Arc(q, r, 8));
		arcs.add(new Arc(r, n, 1));
		arcs.add(new Arc(r, t, 5));
		arcs.add(new Arc(s, z, 2));
		arcs.add(new Arc(t, z, 8));
		Solution sol = shortestPath(arcs, a, z, "test6");
		//runFor("6", arcs, nodes, a, z, 16);

	}
/*	
	static void runFor(String name, Set<Arc> arcs, Set<Node> nodes, Node from, Node to, int total) {
		//Graph g = new Graph(1, nodes, arcs);
		Path path = shortestPath(from, to, new Graph(1, nodes, arcs));
		System.out.println("@@@@@@ Shortest path for " + name + ": " + path);
		assertEquals(total, path.getValue());

	}

	static class Graph {
		private int id;
		private Set<Node> nodes;
		private Set<Arc> arcs;
		
		Graph(int id, Set<Node> nodes, Set<Arc> arcs) {
			this.id=id;
			this.nodes=nodes;
			this.arcs=arcs;
		}
		public int getId() {
			return id;
		}
		public Set<Node> getNodes() {
			return nodes;
		}
		public Set<Arc> getArcs() {
			return arcs;
		}
		public Set<Arc> getUnvisitedNodeArcs(Node from) {
			Set<Arc> nodeArcs = new HashSet<Arc>();
			for (Arc arc: arcs) {
				if (arc.from.equals(from)) {
				//if (arc.from.equals(from) && !arc.to.isVisited()) {
					nodeArcs.add(arc);
				}
			}
			return nodeArcs;
		}
	}

//	static class Table {
//		private String name;
//		private boolean visited;
//		public Table(String name) {
//			super();
//			this.name = name;
//			this.visited = false;
//		}
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public boolean isVisited() {
//			return visited;
//		}
//		public void setVisited(boolean visited) {
//			this.visited = visited;
//		}
//		
//	}
	}
*/
}