package main;

public class BreadthFirstTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tree = sampleTree();
		
		Bfs.traversal(tree);
//		DfsNonRecursive.traversal(tree);
		

	}

//private static Node sampleGraph() {
//		
//		Node source = new Node ("A", false, 
//									new Node("B", false, 
//											new Node("C", false,null, null), 
//											new Node("D", false,null, null)), 
//									new Node("E",false, 
//											new Node("F", false,null, null), 
//											new Node("G", false,
//													new Node("H", false,null, null), null)));
//								
//		Node root = new Node ("A", 
//						new Node ("B", 
//								new Node("C",
//										null, new Node("2")), new Node("D")),
//						new Node("E", 
//								new Node("F"), new Node("G",
//															null, new Node("H"))));
					
//		return source;
//	}
	private static Node sampleTree() {
		
		Node root = new Node ("A", false, 
									new Node("B", false, 
											new Node("C", false,null, null), 
											new Node("D", false,null, null)), 
									new Node("E",false, 
											new Node("F", false,null, null), 
											new Node("G", false,
													new Node("H", false,null, null), null)));
								
//		Node root = new Node ("A", 
//						new Node ("B", 
//								new Node("C",
//										null, new Node("2")), new Node("D")),
//						new Node("E", 
//								new Node("F"), new Node("G",
//															null, new Node("H"))));
					
		return root;
	}
//	private static Node sampleTree() {
//		Node root = new Node ("A", 
//						new Node ("B", 
//								new Node("C",
//										null, new Node("2")), new Node("D")),
//						new Node("E", 
//								new Node("F"), new Node("G",
//															null, new Node("H"))));
//					
//		return root;
//	}

	
	
//	private static Node sampleTree() {
//		Node root = new Node ("A", 
//						new Node ("B", 
//								null, new Node("D")),
//						new Node("E", 
//								new Node("F"), new Node("G",
//										new Node("H"), null)));
//					
//		return root;
//	}
}


