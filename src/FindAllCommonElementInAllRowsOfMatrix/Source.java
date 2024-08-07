package FindAllCommonElementInAllRowsOfMatrix;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
Find All Common Element in Each Row of Matrix
Description
Given an M x N matrix of integers, find all the common elements that are present in all rows of the given matrix in O(M * N) time.

For example, take a look at the matrix given below.

11 12 11 14 18

13 17 18 15 11

18 17 17 13 11

18 11 12 17 19

In this matrix, 11 and 18 appear in each row. Hence, 11 and 18 will be the common elements that are present in each row.



Note that if multiple common elements are present in each row, you need to print them in ascending order.





Input Format:

The first line contains two integers M as the number of rows and N as the number of columns.

From the next line, there are N elements in a line up to M lines, representing the elements of the matrix.



Output Format:

The output contains all the common elements that are present in each row of the given matrix, printed in ascending order.





Sample Test Cases:

Input:

4 5

11 12 11 14 18

13 17 18 15 11

18 17 17 13 11

18 11 12 17 19



Output:

11 18





Input:

4 4

17 12 11 10

13 17 10 15

10 17 17 13

12 11 10 17



Output:

10 17
 */
public class Source {

    public static void printElementInAllRows(int mat[][]) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0 ; i < mat.length ; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0) {
                    map.put(mat[i][j], 1);
                } else {
                    if (map.containsKey(mat[i][j]) && map.get(mat[i][j]) == i) {
                        map.put(mat[i][j], i + 1);
                    }
                }
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int key : keys) {
            if (map.get(key) == mat.length) {
                System.out.print(key + " ");
            }
        }




    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        printElementInAllRows(matrix);
    }
}