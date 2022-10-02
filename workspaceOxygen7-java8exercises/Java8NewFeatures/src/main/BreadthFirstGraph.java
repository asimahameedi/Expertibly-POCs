package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = createGraph();
		Set<String> trav = breadthFirstTraversal(g, "2");
//		Set<String> trav = breadthFirstTraversal(g, "Bob");
		trav.forEach(System.out::println);
		
		boolean found =breadthFirstSearch( "5", g , "2");
		System.out.println(found);
	}

	static Graph createGraph() {
		Graph graph = new Graph();
//	    graph.addVertex("Bob");
//	    graph.addVertex("Alice");
//	    graph.addVertex("Mark");
//	    graph.addVertex("Rob");
//	    graph.addVertex("Maria");
//	    graph.addEdge("Bob", "Alice");
//	    graph.addEdge("Bob", "Rob");
//	    graph.addEdge("Alice", "Mark");
//	    graph.addEdge("Rob", "Mark");
//	    graph.addEdge("Alice", "Maria");
//	    graph.addEdge("Rob", "Maria");
//undirected graphs
		graph.addVertex("0");
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");

		graph.addEdge("2", "0");
		graph.addEdge("2", "3");
		graph.addEdge("0", "1");
		graph.addEdge("0", "2");
		graph.addEdge("1", "2");
		graph.addEdge("2", "1");
		
////		graph.addEdge("3", "3");
		return graph;
	}

	static Set<String> breadthFirstTraversal(Graph graph, String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			String vertex = queue.poll();
			for (Vertex v : graph.getAdjVertices(vertex)) {
				if (!visited.contains(v.label)) {
					visited.add(v.label);
					queue.add(v.label);
				}
			}
		}
		return visited;
	}
	
	static boolean breadthFirstSearch(String searchLabel, Graph graph, String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		boolean found=false;
		if (searchLabel.equals(root)) {
			found=true;
		} else {
		
				queue.add(root);
				visited.add(root);
				while (!queue.isEmpty()) {
					String vertex = queue.poll();
					if (vertex.equals(searchLabel)) {
						found = true;
						break;
					}
					
					for (Vertex v : graph.getAdjVertices(vertex)) {
						if (!visited.contains(v.label)) {
							visited.add(v.label);
							queue.add(v.label);
						}
					}
				}
			}
		return found;
	}

}

class Vertex {
	String label;

	Vertex(String label) {
//    	System.out.println("vertex label " + label);
		this.label = label;
	}

	@Override
	public int hashCode() {
		return Objects.hash(label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return Objects.equals(label, other.label);
	}

}

class Graph {
	private Map<Vertex, List<Vertex>> adjVertices = new HashMap<Vertex, List<Vertex>>();

	// standard constructor, getters, setters - I created the setters & getters
	// gets all vertices
	public Map<Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}

	void addVertex(String label) {
		// this was giving nullpointer exception because adjVertices collection was only declared but not created
		adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}

	void removeVertex(String label) {
		Vertex v = new Vertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(v));
		adjVertices.remove(new Vertex(label));
	}

	void addEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjVertices.get(v1).add(v2);
		adjVertices.get(v2).add(v1);
	}

	void removeEdge(String label1, String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex> eV1 = adjVertices.get(v1);
		List<Vertex> eV2 = adjVertices.get(v2);
		if (eV1 != null)
			eV1.remove(v2);
		if (eV2 != null)
			eV2.remove(v1);
	}

	List<Vertex> getAdjVertices(String label) {
		return adjVertices.get(new Vertex(label));
	}
}
