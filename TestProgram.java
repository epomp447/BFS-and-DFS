package BFS;



public class TestProgram {

	public static void main(String[] args) {
		Graph G = new Graph(5);
		G.edge(0, 1);
		G.edge(0, 2);
		G.edge(1, 2);
		G.edge(2, 0);
		G.edge(2, 3);
		G.edge(3, 3);
		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		G.BFS(2);
		System.out.println("\nFollowing is Depth First Traversal " + "(starting from vertex 2)");
		G.DFS(2);
		System.out.print("\n\n\n");
		for (int i = 0; i < 4; i++) {
			System.out.print(i+"-> ");

			System.out.println(G.getVertex(i).toString());
		}
	}
}
