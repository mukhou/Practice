package goldmansachs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataStructures.stacksandqueues.StackUsingArray;

public class TopologicalSort {

}
// EXACT LOGIC AS DFS
class Graph {
	int vertices;

	// map of vertex, adj_vertex_list
	Map<Integer, List<Integer>> map;

	Graph(int vertices) {
		this.vertices = vertices;
		map = new HashMap<Integer, List<Integer>>();

	}
	// create vertex-edge pair
	void addEdge(int v, int w) {
		List<Integer> edges = map.get(v);
		if (edges == null) {
			map.put(v, new ArrayList<Integer>(w));
		} else {
			edges.add(w);
			map.put(v, edges);
		}

	}
	
	// main method
	void topologicalSortUtil() {
		// initialize stack
		StackUsingArray stack = new StackUsingArray();
		boolean[] visited = new boolean[vertices];
		// initially mark all vertices as not visited
		for (int i = 0; i < vertices; i++) {
			visited[i] = false;
		}
		// Call the recursive helper function to store Topological Sort
		// starting from all vertices one by one
		for (int i = 0; i < vertices; i++) {
			if (visited[i] == false) {
				topologicalSortUtil(i, visited, stack);

			}
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	// helper method
	void topologicalSortUtil(int v, boolean[] visited, StackUsingArray stack) {
		// mark current vertex as visites
		visited[v] = true;
		// get all its adjacent vertices
		List<Integer> adj_edges = map.get(v);
		// recur for them
		for (int i : adj_edges) {
			if (visited[i] == false) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		// push only when all of adjacent edges of a vertex
		// has been marked as visited 
		stack.push(v);

	}


}
