package MostFrequentElement;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

/*
Most Frequent Element
Description
Given an array of integers, find the most frequent element in the array. If multiple elements appear a maximum number of times, print any one of them. Return -1 in case there are no elements.



Input Format:

The first line contains the size of the array, N.

The second line contains the elements of the array.



Output Format:

The output contains the most frequent element in the array.



Sample Test Cases:

Input:

8

1 3 2 5 2 1 9 2



Output:

2



Input:

8

10 15 12 11 13 12 11 11



Output:

11

Input:
5
7 8 9 4 9

output:
9

This is because out of the elements [7 8 9 4 9], 9 is the only one which occurs the maximum no. of times (twice)



Sample input 2:
0

Sample output 2:
-1

This is because no elements are there over which the function may be called, hence we return -1
 */

public class Source {

    public static int mostFrequentElement(int[] arr) {
        if(arr.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxCount = 0;
        int mostFrequent = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                mostFrequent = Math.min(mostFrequent, entry.getKey());
                // If the current element is less than the previously stored most frequent element,
                // update mostFrequent with the current element.
            }
        }
        return mostFrequent;
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mostFrequentElement(arr));
    }
}
