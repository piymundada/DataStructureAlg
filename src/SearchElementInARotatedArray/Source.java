package SearchElementInARotatedArray;

import java.util.*;

/*
Search Element in a Rotated Array
Description
Suppose you rotate an array of integers that is sorted in increasing order, at an unknown pivot. Check whether the given key is present in the array or not. Construct a way to find an element in the given array in O(log n) time, where n is the number of elements in the array.

For example, 14 15 16 17 18 19 11 12 13 is an array that is sorted in increasing order and rotated at 11.





Input Format:

The first line contains an integer N as the size of the array.

The second line contains elements of the array.

The third line contains the key to be searched in the given array.



Output Format:

Print the index of an array if the key is found in the array, else print -1.



Sample Test Cases:

Input:

9

14 15 16 17 18 19 11 12 13

6



Output:

-1





Input:

9

14 15 16 17 18 19 11 12 13

11



Output:

6
 */
public class Source {

    public static int search(int arr[], int left, int right, int key) {
            if (left > right) {
                return -1;
            }

            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (key >= arr[left] && key <= arr[mid]) {
                    return search(arr, left, mid - 1, key);
                } else {
                    return search(arr, mid + 1, right, key);
                }
            } else {
                if (key >= arr[mid] && key <= arr[right]) {
                    return search(arr, mid + 1, right, key);
                } else {
                    return search(arr, left, mid - 1, key);
                }
            }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int i = search(arr, 0, n - 1, key);
        if (i != -1) {
            System.out.println(i);
        } else {
            System.out.println("-1");
        }
    }
}
