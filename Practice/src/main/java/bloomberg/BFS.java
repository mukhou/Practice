package bloomberg;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 */
public class BFS {

    //no. of vertices
    private int V;
    private LinkedList<Integer>[] adjacentEdges;

    //constructor
    BFS(int v){
        this.V = v;
        for(int i = 0; i < v; i++){
            adjacentEdges[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int e){
        adjacentEdges[v].add(e);
    }

    void breadthFirstSearch(int s){
        //created visited array and queue
        boolean[] visited  =  new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        //enqueue and mark visited
        queue.add(s);
        visited[s] = true;

        while(queue.size() != 0){

            //dequeue
            s = queue.poll();
            //print
            System.out.println(s);
            Iterator<Integer> edges = adjacentEdges[s].listIterator();
            while(edges.hasNext()){
                int node = edges.next();
                if(!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                }

            }

        }
    }

}
