package SortNearlySortedArray;

import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
Sort Nearly Sorted Array
Description
Given a k-sorted array of n elements, where each element is at most k steps away from its target position as it would have been in an array that is sorted in ascending order. Write a program to sort the array in O(n log k) time.



For example, an element at index i in an array that was sorted in ascending order can be found at indexes i - 3, i - 2, i - 1, i, i + 1, i + 2 and i + 3 in the given k-sorted array.





Input Format:

The first line contains an integer ‘N’ as the size of the array.

The second line contains an integer ‘K’ representing the maximum number of steps that each element can deviate from its target position as it would have been in an array that is sorted in ascending order.

The third line contains the elements of the k-sorted array.



Output Format:

The output contains the elements of the array that is sorted in ascending order.



Sample Test Cases:

Input:

7

3

7 6 4 3 9 11 10



Output:

3 4 6 7 9 10 11





Input:

7

3

6 5 3 2 8 10 9



Output:

2 3 5 6 8 9 10
 */
public class Source {

    private static void sortArray(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        ksorter(list, 0, list.size() - 1, k);

       for(int i = 0; i < arr.length; i++) {
           arr[i] = list.get(i);
       }

    }

    public static int sort(ArrayList<Integer> arr, int l,
                           int h, int k)
    {
        int mid
                = l + (h - l) / 2; // choose middle element as pivot
        int i = Math.max(l, mid - k), j = i,
                end = Math.min(mid + k,
                        h); // set appropriate ranges
        Collections.swap(
                arr, end, mid); // swap middle and last element
        // to avoid extra complications
        while (j < end) {
            if (arr.get(j) < arr.get(end)) {
                Collections.swap(arr, j, i++);
            }
            j = j + 1;
        }
        Collections.swap(arr, end, i);
        return i;
    }

    public static void ksorter(ArrayList<Integer> arr,
                               int l, int h, int k)
    {
        if (l < h) {
            int q = sort(arr, l, h, k);
            ksorter(arr, l, q - 1, k);
            ksorter(arr, q + 1, h, k);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}