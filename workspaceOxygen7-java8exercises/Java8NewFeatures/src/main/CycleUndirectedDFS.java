package main;
import java.util.*;


//To detect if there is any cycle in the undirected graph or not, we will use the DFS traversal for the given graph. 
//For every visited vertex v, when we have found any adjacent vertex u, such that u is already visited, and u is not 
//the parent of vertex v. Then one cycle is detected.
public class CycleUndirectedDFS {
	
		private int V; // No. of vertices

// Array of lists for Adjacency List Representation
//		private LinkedList<Integer> adj[];
		//each array element contains an arraylist
		private ArrayList<Integer> adj[];

		// Constructor
		CycleUndirectedDFS(int v) {
			V = v;
//			adj = new LinkedList[v];
			//creating an arraylist of arraylist
			adj = new ArrayList[v];
			for (int i = 0; i < v; ++i)
//				adj[i] = new LinkedList();
			adj[i] = new ArrayList();
		}

		// Function to add an edge into the graph
		void addEdge(int v, int w) {
			adj[v].add(w); // Add w to v's list.
		}
		
	
		//To detect if there is any cycle in the undirected graph or not, we will use the DFS traversal for the given graph. 
		//For every visited vertex v, when we have found any adjacent vertex u, such that u is already visited, and u is not 
		//the parent of vertex v. Then one cycle is detected.
		// A function used by DFS
		void DFSUtil(int v, boolean visited[]) {
			// Mark the current node as visited and print it
			visited[v] = true;
			System.out.print(v + " ");

			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> i = adj[v].listIterator();
			System.out.println("iterator is " + i.hasNext());
			System.out.println("v is " + v);
			while (i.hasNext()) {
				int n = i.next();
				System.out.println("n is " + n);
				if (!visited[n]) {
					System.out.println("not visited" );
					DFSUtil(n, visited);
				}
				else {
					
//					System.out.println("v is " + v);
					System.out.println("cycle is true " + n);
				}
			}
		}
		
		

		// The function to do DFS traversal. It uses recursive DFSUtil()
		void DFS(int v) {
			// Mark all the vertices as not visited(set as
			// false by default in java)
			
			boolean visited[] = new boolean[V];

			// Call the recursive helper function to print DFS traversal
			DFSUtil(v, visited);
		}

		public static void main(String args[]) {
			CycleUndirectedDFS g = new CycleUndirectedDFS(4);

//			g.addEdge(0, 1);
//			g.addEdge(0, 2);
//			g.addEdge(1, 2);
//			g.addEdge(2, 0);
//			g.addEdge(2, 3);
//			g.addEdge(3, 3);

			
			g.addEdge(0, 1);
			g.addEdge(0, 2);
//			g.addEdge(1, 2);
//			g.addEdge(2, 0);
			g.addEdge(2, 3);
//			g.addEdge(3, 3);
			g.addEdge(3, 1);
//			System.out.println("Following is Depth First Traversal " + "(starting from vertex 3)");

			g.DFS(0);
		}
	}
	

