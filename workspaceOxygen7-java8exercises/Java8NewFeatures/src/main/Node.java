package main;

//public class Node {
//	Node left;
//	Node right;
//	String data;
//	
//	public Node(String data) {
//		this.data = data;
//	}
//	
//	public Node(String data, Node left, Node right) {
//		this.data = data;
//		this.left = left;
//		this.right = right;
//	}

public class Node {
	Node left;
	Node right;
	String data;
//	boolean visited;
	
	

	

//	public boolean isVisited() {
//		return visited;
//	}

//	public void setVisited(boolean visited) {
//		this.visited = visited;
//	}

	public Node(String data, boolean visited) {
		this.data = data;
//		this.visited = visited;
	}
	
	public Node(String data, boolean visited, Node left, Node right) {
		this.data = data;
//		this.visited = visited;
		this.left = left;
		this.right = right;
		
	}
	
}
