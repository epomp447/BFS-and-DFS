package BFS;

import java.util.Iterator;
import java.util.LinkedList;


class Graph {
	// A user define class to represent a graph.
	// A graph is an array of adjacency lists.
	// Size of array will be V (number of vertices
	// in graph)

	private int V;
	private LinkedList<Integer> adjListArray[];
	private String C;

	// constructor
	Graph(int V) {
		this.V = V;

		// define the size of array as
		// number of vertices
		adjListArray = new LinkedList[V];

		// Create a new list for each vertex
		// such that adjacent nodes can be stored
		for (int i = 0; i < V; i++) {
			adjListArray[i] = new LinkedList<>();
		}

	}

	// constructor
	Graph(int V, String C) {
		this.V = V;
		this.C = C;
		// define the size of array as
		// number of vertices
		adjListArray = new LinkedList[V];

		// Create a new list for each vertex
		// such that adjacent nodes can be stored
		for (int i = 0; i < V; i++) {
			adjListArray[i] = new LinkedList<>();
		}

	}

	LinkedList<Integer> getVertex(int v) {
		return adjListArray[v];
	}

	int getSize() {
		return V;
	}

	void edge(int v, int w) {
		adjListArray[v].add(w);
	}

	void BFS(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean[] visited = new boolean[V];
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// dequeue a vertex from the queue and print that shit
			s = queue.poll();
			System.out.print(s + " ");
			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adjListArray[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// A function used by DFS
	void DFSvisit(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adjListArray[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSvisit(n, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		DFSvisit(v, visited);
	}

}
