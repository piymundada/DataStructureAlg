package GraphIsTreeOrNot.Simple;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Find if the graph is a tree or not.



The degree of a vertex is given by the number of edges incident or leaving from it.

Some useful properties are as follows:

Tree is connected and has no cycles while graphs can have cycles.
Tree has exactly n-1 edges while there is no such constraint for graph.
It is given that the input graph is connected. We need at least n-1 edges to connect n nodes.
If we take the sum of all the degrees, each edge will be counted twice. Hence, for a tree with n vertices and n – 1 edges, sum of all degrees should be 2 * (n – 1)



Input:

First line contains an integer N, the number of vertices.

Second line contains N space-separated integers, the degrees of the N vertices.

eg:

3

1 2 1



Output:

Print "Yes" (without the quotes) if the graph is a tree or "No" (without the quotes) otherwise

eg:

Yes
 */
// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc= new Scanner(System.in);
        int n= 10;
        if(sc.hasNextInt()){
            n=sc.nextInt();
        }
        int degree[]=new int[n];
        for(int i=0;i<n;i++){
            if(sc.hasNextInt()){
                degree[i]=sc.nextInt();
            }
        }

        if (check(degree, n))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }

    private static boolean check(int[] degree, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += degree[i];
        }
        return sum == 2 * (n - 1);
    }
}
