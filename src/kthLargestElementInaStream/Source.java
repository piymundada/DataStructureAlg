package kthLargestElementInaStream;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
Find kth Largest Element in a Stream
Description
Given an infinite stream of integers, find the kth largest element at any point in time.



Input Format:

The first line contains an integer ‘N’ as the size of the stream.

The second line contains an integer ‘K’ representing the position of the largest number.

The third line contains elements of the stream of size ‘N’.



Output Format:

The output contains the kth largest number at any point in time. If the kth largest number does not exist, then print ‘None’ (without quotes and with capital letter ‘N’).



Sample Test Cases:

Input:

8

3

20 30 21 80 60 50 110 15



Output:

None

None

3 largest number is 20

3 largest number is 21

3 largest number is 30

3 largest number is 50

3 largest number is 60

3 largest number is 60





Input:

5

2

10 40 11 20 60



Output:

None

2 largest number is 10

2 largest number is 11

2 largest number is 20

2 largest number is 40
 */

public class Source {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int stream[] = new int[n];

        for (int i = 0; i < n; i++) {

            stream[i] = sc.nextInt();

        }

        kthLargest(stream, n, k);
        sc.close();
    }
    static void kthLargest(int stream[], int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(stream[i]);
            if (i < k - 1) {
                System.out.println("None");
            } else {
                System.out.println(k+ " largest number is " +pq.peek());
            }
        }
        for (int i = k; i < n; i++) {
            if (stream[i] > pq.peek()) {
                pq.poll();
                pq.add(stream[i]);
            }
            System.out.println(k+ " largest number is " + pq.peek());
        }
    }
}