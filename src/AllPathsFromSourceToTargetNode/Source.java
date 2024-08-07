package AllPathsFromSourceToTargetNode;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Scanner;

/*
Given a directed acyclic graph (DAG) of n nodes labelled from 0 to n - 1, count all possible paths from node 0 to node n - 1, and return the number of paths.



The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e. , there is a directed edge from node i to node graph[i][j]).



Example:





Input:

If graph = [[1,2],[3],[3],[]], the input can be taken as follows:



first line: (number of nodes) 4

second line: (nodes you can visit from first node) 1 2

third line: (nodes you can visit from second node) 3

fourth line: (nodes you can visit from third node) 3

fifth line:( nodes you can visit from fourth node) -1



Note: input -1 implies no node can be visited from the given node.



Output: 2

Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class Source {

    /*
    Input format:
    first line: (number of nodes) 4

    second line: (nodes you can visit from first node) 1 2

    third line: (nodes you can visit from second node) 3

    fourth line: (nodes you can visit from third node) 3

    fifth line:( nodes you can visit from fourth node) -1

    Note: input -1 implies no node can be visited from the given node.
     */
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] graph = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] neighbors = scanner.nextLine().split(" ");
            if (neighbors[0].equals("-1")) {
                graph[i] = new int[0];
            } else {
                graph[i] = new int[neighbors.length];
                for (int j = 0; j < neighbors.length; j++) {
                    graph[i][j] = Integer.parseInt(neighbors[j]);
                }
            }
        }
        System.out.println(countPaths(graph));
        scanner.close();

    }

    public static int countPaths(int[][] graph) {
        int n = graph.length;
        int[] memo = new int[n];
        return dfs(graph, 0, n - 1, memo);
    }

    private static int dfs(int[][] graph, int node, int target, int[] memo) {
        if (node == target) {
            return 1;
        }
        if (memo[node] != 0) {
            return memo[node];
        }
        int count = 0;
        for (int neighbor : graph[node]) {
            if (neighbor != -1) {
                count += dfs(graph, neighbor, target, memo);
            }
        }
        memo[node] = count;
        return count;
    }
}
