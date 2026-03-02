package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static List<Integer> bfs(int vertices, List<List<Integer>> adjacentNodes) {
        List<Integer> nodesTraversed = new ArrayList<>();
        boolean visited[] = new boolean[vertices + 1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    nodesTraversed.add(node);
                    List<Integer> neighborNodes = adjacentNodes.get(node);
                    for (int adjacent : neighborNodes) {
                        if (!visited[adjacent]) {
                            visited[adjacent] = true;
                            queue.add(adjacent);
                        }
                    }
                }
            }
        }
        return nodesTraversed;
    }

    public static void main(String args[]) {
        int vertices = 7;

        // Adjacency list for storing which vertices are connected
        List<List<Integer>> adjacentNodes = new ArrayList<>(vertices + 1);
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

        System.out.println(bfs(vertices, adjacentNodes));
    }

    private static void addEdge(List<List<Integer>> adj, int i, int j) {
        System.out.println(i + " " + j);
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

//    1 -> 2
//    3 -> 4, 7
//    4->
}
