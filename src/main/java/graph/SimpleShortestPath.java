package graph;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import org.junit.Test;


public class SimpleShortestPath {
//assume vertices are labeled positive integer number from 1 to n
//define Arc as a directed line from a vertex to the other vertex and we are assuming unique arc between unique vertices
	//private static final Map<Table, Set<Table>> parentTablesMap = new HashMap<Table, Set<Table>>();
	//private static final Map<Table, Set<Table>> childTablesMap = new HashMap<Table, Set<Table>>();

	public static void main(String[] args) {
		shortestFloydWarshall();
	}
	static void shortestFloydWarshall() {
		Set<Edge> edges = new HashSet<Edge>();
		edges.add(new Edge(0, 2,  9)); //*
		edges.add(new Edge(0, 6, 14));
		edges.add(new Edge(0, 1, 15));
		edges.add(new Edge(2, 3, 24)); //*
		edges.add(new Edge(1, 7, 44));
		edges.add(new Edge(6, 3, 18));
		edges.add(new Edge(6, 5, 30));
		edges.add(new Edge(6, 1,  5));
		edges.add(new Edge(5, 4, 11));
		edges.add(new Edge(5, 7, 16));
		edges.add(new Edge(3, 5,  2));
		edges.add(new Edge(3, 7, 19));
		edges.add(new Edge(4, 3, 45));
		edges.add(new Edge(4, 7,  6));
		//runFor("1", arcs, nodes, 0, 5, 2);
		//floydWarshall(edges);
		
		System.out.println("------------------------------------");
		Solution sol = shortestPath(edges);
		System.out.println(Arrays.asList(sol.getDist()));
		System.out.println(Arrays.asList(sol.getPred()));
		
		edges = new HashSet<Edge>();
		edges.add(new Edge(0, 1, 1)); //*
		edges.add(new Edge(0, 2, 1));
		edges.add(new Edge(1, 3, 1));
		edges.add(new Edge(1, 4, 1)); //*
		edges.add(new Edge(2, 3, 1));
		edges.add(new Edge(3, 4, 1));
		//runFor("1", arcs, nodes, 0, 5, 2);
		//floydWarshall(edges);
		sol = shortestPath(edges);
		System.out.println(Arrays.asList(sol.getDist()));
		System.out.println(Arrays.asList(sol.getPred()));
		
		System.out.println("------------------------------------");

		edges = new HashSet<Edge>();
		edges.add(new Edge(0, 1, 3)); //*
		edges.add(new Edge(0, 2, 8));
		edges.add(new Edge(3, 0, 2));
		edges.add(new Edge(0, 4,-4)); //*
		edges.add(new Edge(2, 1, 4));
		edges.add(new Edge(1, 3, 1));
		edges.add(new Edge(1, 4, 7));
		edges.add(new Edge(3, 2,-5));
		//runFor("1", arcs, nodes, 0, 5, 2);
		//floydWarshall(edges);
		System.out.println("------------------------------------");
		
	}
	static void floydWarshall(Set<Edge> edges) {
		Set<Integer> nodes = new HashSet<Integer>();
		for (Edge e : edges) {
			nodes.add(e.v);
			nodes.add(e.w);
		}
		int size = nodes.size();
		Integer[][] dist = new Integer[size][size];
		Integer[][] path = new Integer[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i==j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = null;
//					dist[i][j] = Integer.MAX_VALUE;
				}
				path[i][j] = null;
//				path[i][j] = Integer.MAX_VALUE;
			}
		}

		for (Edge e : edges) {
			dist[e.v][e.w] = e.weight();
			dist[e.w][e.v] = e.weight();
		}
		
//		for (int i = 0; i<size; i++) {
//			System.out.println(Arrays.asList(dist[i]));
//		}
//		System.out.println("------------------------------------");
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (dist[i][k]==null||dist[k][j]==null)continue;
//					if (dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE)continue;
					int newVal = dist[i][k] + dist[k][j];
					if (dist[i][j]==null || newVal < dist[i][j])	{
						dist[i][j] = newVal;
						path[i][j] = k;
					}
				}		
			}
		}
		for (int i = 0; i<size; i++) {
			System.out.println(Arrays.asList(dist[i]));
		}
		System.out.println("------------------------------------");
		for (int i = 0; i<size; i++) {
			System.out.println(Arrays.asList(path[i]));
		}

	}
	static class Edge implements Comparable<Edge> {
		public final int v, w;
		public final int weight;
		public Edge(int v, int w, int weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}
		public int from() {
			return v; 
			}
		public int to()	{
			return w; 
		}
		public int weight()	{
			return weight; 
		}
		public int compareTo(Edge that)	{
			if (this.weight < that.weight) return -1;
			if (this.weight > that.weight) return +1;
			return 0;
		}
		public String toString() {
			return "Edge[" + weight + ": " + v + " to " + w + "]";

		}
	}
	static Solution shortestPath(Set<Edge> edges) {
		Set<Integer> nodes = new HashSet<Integer>();
		for (Edge e : edges) {
			nodes.add(e.v);
			nodes.add(e.w);
		}
		int size = nodes.size();
		Integer[] dist = new Integer[size];
		Edge[] pred = new Edge[size];
		for (int v = 1; v < size; v++) {
			dist[v] = null;
		}

		dist[0] = 0;
		
		for (int i = 0; i < size; i++) {
			for (int v = 0; v < size; v++) {
				for (Edge e : getVEdges(edges, v))	{
					int w = e.to();
					if (dist[v]==null)continue;
					int minValue = dist[v] + e.weight();
					if (dist[w]==null || dist[w] > minValue)	{
						dist[w] = minValue;
						pred[w] = e;
					}
				}		
			}
		}
//		System.out.println(Arrays.asList(dist));
//		System.out.println(Arrays.asList(pred));
		return new Solution(dist, pred);
	}
	static Set<Edge> getVEdges(Set<Edge> edges, int v) {
		Set<Edge> vEdges = new HashSet<Edge>();
		for (Edge e : edges) {
			if (e.from()==v) {
				vEdges.add(e);
			}
		}
		return vEdges;
	}
	static class Solution {
		private Integer[] dist; 
		private Edge[] pred; //path from node
		public Solution(Integer[] dist, Edge[] pred) {
			super();
			this.dist = dist;
			this.pred = pred;
		}
		public Integer[] getDist() {
			return dist;
		}
		public void setDist(Integer[] dist) {
			this.dist = dist;
		}
		public Edge[] getPred() {
			return pred;
		}
		public void setPred(Edge[] pred) {
			this.pred = pred;
		}
		
	}

/*
	static void test() {
		//shortest();
		//Map<Node, Set<Arc>> nodeArcs = new HashMap<Node, Set<Arc>>();
		//Map<Node, Set<Node>> node2NodeArcs = new HashMap<Node, Set<Node>>();
		//Map<Table, List<Table>> tableRelations = new HashMap<Table, List<Table>>();
		//shortest(a,b) = Min{arc(a,v).value + shortest(v,b) where v is any adjacent node to a}
		//v is chosen as the one which the min occurs for it
		test1();
		//@@@@@@ Shortest path for 1: 2 : [Arc[1: one to two], Arc[1: two to seven]]
		
		test2();
		//@@@@@@ Shortest path for 2: 3 : [Arc[1: one to three], Arc[1: three to four], Arc[1: four to seven]]

		test3();
		//@@@@@@ Shortest path for 3: 11 : [Arc[7: one to five], Arc[4: five to four]]
		//@@@@@@ Shortest path for 3: 12 : [Arc[5: one to two], Arc[3: two to five], Arc[4: five to four]]
		//Exception in thread "main" java.lang.AssertionError: expected:<11> but was:<12>

		test4();
		//@@@@@@ Shortest path for 4: 11 : [Arc[1: s to a], Arc[3: a to c], Arc[2: c to f], Arc[5: f to t]]

		//http://stackoverflow.com/questions/10254542/dijkstras-algorithm-does-not-generate-shortest-path
		test5();
		//@@@@@@ Shortest path for 5: 20 : [Arc[4: a to c], Arc[1: b to e], Arc[5: d to f], Arc[2: g to k], Arc[2: c to f], Arc[3: e to h], Arc[2: f to i], Arc[1: h to l], Arc[2: i to m], Arc[3: j to n], Arc[2: m to p], Arc[6: l to o], Arc[2: o to p], Arc[2: k to r], Arc[1: r to n], Arc[2: n to q], Arc[1: q to p], Arc[2: p to s], Arc[2: s to z]]

		test6();


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
		runFor("1", arcs, nodes, n1, n7, 2);
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
		Set<Arc>arcs = new HashSet<Arc>();
		arcs.add(new Arc(n1, n2, 3));
		arcs.add(new Arc(n1, n3, 1));
		arcs.add(new Arc(n2, n4, 1));
		arcs.add(new Arc(n2, n7, 1));
		arcs.add(new Arc(n3, n4, 1));
		arcs.add(new Arc(n4, n7, 1));
		runFor("2", arcs, nodes, n1, n7, 3);
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
		runFor("3", arcs, nodes, n1, n4, 11);
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
		runFor("4", arcs, nodes, s, t, 11);
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
		runFor("5", arcs, nodes, a, z, 16);
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
		runFor("6", arcs, nodes, a, z, 16);

	}
	
	static void runFor(String name, Set<Arc> arcs, Set<Node> nodes, Node from, Node to, int total) {
		//Graph g = new Graph(1, nodes, arcs);
		Path path = shortestPath(from, to, new Graph(1, nodes, arcs));
		System.out.println("@@@@@@ Shortest path for " + name + ": " + path);
		assertEquals(total, path.getValue());

	}

	static Path shortestPath(Node start, Node end, Graph g) {
		if (start.equals(end)) {
			return null;
		}
		if (start.getMinPath()!=null) {
			return start.getMinPath();
		}
		//recursively find arcs leaving from a given node and loop in them and add value to the shortest between the end node of each arc
//		start.setVisited(true);
		Set<Arc> leavingArcs = g.getUnvisitedNodeArcs(start);
		int minValue = Integer.MAX_VALUE;
		Arc minArc = null;
		Path minPath = null;
		//13 : [Arc[1: h to l], Arc[6: l to o], Arc[2: o to p], Arc[2: p to s], Arc[2: s to z]]
		for (Arc arc: leavingArcs) {
			Path path = shortestPath(arc.getTo(), end , g);
			if (path==null) {
				path = new Path();
			}
			int val = arc.getValue() + path.getValue();
			if (val < minValue) {
				minValue = val;
				minArc = arc;
				minPath = path;
			}
		}
		if (minPath!=null) {
			minPath.addArc(minArc);
			minPath.setValue(minValue);
		} else {
			minPath = new Path();
		}
		System.out.println(minPath);
		start.setMinPath(minPath);
		return minPath;
	}
	static void shortest() {
		Set<Edge> edges = new HashSet<Edge>();
		edges.add(new Edge(0, 1, 1)); //*
		edges.add(new Edge(0, 2, 1));
		edges.add(new Edge(1, 3, 1));
		edges.add(new Edge(1, 5, 1)); //*
		edges.add(new Edge(2, 3, 1));
		edges.add(new Edge(3, 5, 1));
		//runFor("1", arcs, nodes, 0, 5, 2);
		int size = edges.size();
		Integer[] dist = new Integer[size];
		Edge[] pred = new Edge[size];
		int s = 0;
		for (int v = 1; v < size; v++) {
			dist[v] = Integer.MAX_VALUE;
		}
		dist[s] = 0;
		
		for (int i = 1; i <= size; i++) {
			for (int v = 0; v < size; v++) {
				for (Edge e : getVEdges(edges, v))	{
					int w = e.to();
					if (dist[w] > dist[v] + e.weight())	{
						dist[w] = dist[v] + e.weight();
						pred[w] = e;
					}
				}		
			}
		}
		System.out.println(Arrays.asList(dist));
		System.out.println(Arrays.asList(pred));
	}
	static Set<Edge> getVEdges(Set<Edge> edges, int v) {
		Set<Edge> vEdges = new HashSet<Edge>();
		for (Edge e : edges) {
			if (e.from()==v) {
				vEdges.add(e);
			}
		}
		return vEdges;
	}
//	static Path shortestPath(Node start, Node end, Graph g) {
//		if (start.equals(end)) {
//			return null;
//		}
//		//recursively find arcs leaving from a given node and loop in them and add value to the shortest between the end node of each arc
//		//List<Arc> path = new ArrayList<Arc>();
//		//get arcs leaving from a node start
//
//		start.setVisited(true);
//		Set<Arc> leavingArcs = g.getUnvisitedNodeArcs(start);
//		int minValue = Integer.MAX_VALUE;
//		Arc minArc = null;
//		Path minPath = null;
//		for (Arc arc: leavingArcs) {
//			Path path = shortestPath(arc.getTo(), end , g);
//			if (path!=null) {
//				int val = arc.getValue() + path.getValue();
//				if (val < minValue) {
//					minValue = val;
//					minArc = arc;
//					minPath = path;
//				}
//			}
//		}
//		if (minPath!=null) {
//			minPath.addArc(minArc);
//			minPath.addValue(minValue);
//		} else {
//			minPath = new Path();
//		}
//		return minPath;
//	}
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

	static class Arc {
		Node from;
		Node to;
		int value;
		public Arc(Node from, Node to, int value) {
			this.from=from;
			this.to=to;
			this.value=value;
		}
		public Node getFrom() {
			return from;
		}
		public Node getTo() {
			return to;
		}
		public int getValue() {
			return value;
		}
		@Override
		public String toString() {
			return "Arc[" + value + ": " + from + " to " + to + "]";
		}
	}
	
	static class Node {
		private int id;
		private String label;
		private Path minPath;
		
//		private Set<Arc> arcs;
		//@Transient
//		private boolean visited;
//		public Node(int id, String label, Set<Arc> arcs) {
//			this.id=id;
//			this.label=label;
//			this.arcs=arcs;
//		}
		public Node(String label) {
			this.label=label;
		}
		public Node(int id, String label) {
			this.id=id;
			this.label=label;
		}
		public int getId() {
			return id;
		}
		public String getLabel() {
			return label;
		}
		public Path getMinPath() {
			return minPath;
		}

		public void setMinPath(Path minPath) {
			this.minPath = minPath;
		}

//		public Set<Arc> getArcs() {
//			return arcs;
//		}
//		public boolean isVisited() {
//			return visited;
//		}
//		public void setVisited(boolean visited) {
//			this.visited = visited;
//		}
		@Override
		public String toString() {
			return label;
		}
	}

	static class Path {

		private List<Arc> arcs;
		private int value = 0;

		public Path() {
			this.arcs = new ArrayList<Arc>();
		}
		
//		public Path(List<Arc> arcs, int value) {
//			this.arcs = arcs;
//			this.value = value;
//			//this.arcs.add(arc);
//			//this.value += value;
//		}
//		
		public List<Arc> getArcs() {
			return arcs;
		}

		public void setArcs(List<Arc> arcs) {
			this.arcs = arcs;
		}

		public void addArc(Arc arc) {
			if (this.arcs==null) {
				arcs = new ArrayList<Arc>();
			}
			this.arcs.add(0, arc);
		}
		
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value + " : "+ arcs.toString();
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
	
	static class WeightedDigraph {
		private int V;
		private Set<Edge>[] adj;
		public WeightedDigraph(int V)	{
			this.V = V;
			adj = (Set<Edge>[]) new HashSet[V];
			for (int v = 0; v < V; v++)
			adj[v] = new HashSet<Edge>();
		}
		public void addEdge(Edge e)	{
			int v = e.from();
			adj[v].add(e);
		}
		public Iterable<Edge> adj(int v) {
			return adj[v];
		}
	}
*/}