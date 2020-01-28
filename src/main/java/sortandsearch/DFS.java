package sortandsearch;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adjacentEdges[];

    DFS(int V){
        this.V = V;
        adjacentEdges = new LinkedList[V];
        for (int i=0; i<V; ++i)
            adjacentEdges[i] = new LinkedList();
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v){
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]){
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> edges = adjacentEdges[v].listIterator();
        while (edges.hasNext()){
            int node = edges.next();
            if (!visited[node])
                DFSUtil(node, visited);
        }
    }
}
