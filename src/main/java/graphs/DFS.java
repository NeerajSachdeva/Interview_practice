package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.youtube.com/watch?v=Qzf1a--rhp8
public class DFS {

    private static void dfs(boolean[] visited, int node, List<ArrayList<Integer>> adjacentNodes, List<Integer> nodesTraversed) {
        visited[node] =true;
        nodesTraversed.add(node);
        ArrayList<Integer> neighbourModes = adjacentNodes.get(node);
        for(int neighbour :neighbourModes) {
            if(!visited[neighbour]) {
                dfs(visited,neighbour,adjacentNodes,nodesTraversed);
            }
        }
    }

    public static List<Integer> dfsTraversal(int nodes, List<ArrayList<Integer>> adjacentNodes) {
        List<Integer> nodesTraversed = new ArrayList<>();
        boolean visited[] = new boolean[nodes+1];

        for(int i=1; i<=nodes;i++){
            if(!visited[i]) {
                dfs(visited, i, adjacentNodes, nodesTraversed);
            }
        }
        return nodesTraversed;
    }


    public static void main(String args[]) {
        int vertices = 7;

        // Adjacency list for storing which vertices are connected
        List<ArrayList<Integer>> adjacentNodes = new ArrayList<>(vertices+1);
        for (int i = 0; i <= vertices; i++) {
            adjacentNodes.add(new ArrayList<Integer>());
        }

        // Creating graph given in the above diagram.
        // add_edge function takes adjacency list, source and destination vertex as argument and forms an edge between them.
        addEdge(adjacentNodes, 1, 2);
        addEdge(adjacentNodes, 1, 3);
        addEdge(adjacentNodes, 3, 4);
        addEdge(adjacentNodes, 3, 7);
        addEdge(adjacentNodes, 4, 5);
        addEdge(adjacentNodes, 4, 6);
        addEdge(adjacentNodes, 4, 7);
        addEdge(adjacentNodes, 5, 6);
        addEdge(adjacentNodes, 6, 7);

        System.out.println("adjacentNodes "+adjacentNodes);

        System.out.println(dfsTraversal(vertices, adjacentNodes));
    }

    private static void addEdge(List<ArrayList<Integer>> adj, int i, int j) {
        System.out.println(i + " " + j);
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

//    1 -> 2
//    3 -> 4, 7
//    4-> 5  6  7

}
