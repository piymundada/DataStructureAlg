package FindItineraryInOrder;

import java.util.*;

/*
Find Itinerary in Order
Description
Given a list of tickets in pairs as source city and destination city, find the itinerary in order using the given list.

Note that the given list of tickets is non-cyclic and there is one ticket from each city except the destination city.





Input Format:

The first line contains an integer N representing the number of tickets.

For the next N lines, each line contains a ticket representing the source city and the destination city.



Output Format:

Print ‘Invalid Input’ if the start city is null, else print city in an itinerary in order, a pair in each line as shown below:

Bangalore->Ranchi

Ranchi->Jamshedpur





Sample Test Cases:

Input:

4

Bangalore Ranchi

Jamshedpur Kolkata

Ranchi Jamshedpur

Kolkata Varanasi



Output:

Bangalore->Ranchi

Ranchi->Jamshedpur

Jamshedpur->Kolkata

Kolkata->Varanasi





Input:

4

Chennai Bangalore

Bombay Delhi

Goa Chennai

Delhi Goa



Output:

Bombay->Delhi

Delhi->Goa

Goa->Chennai

Chennai->Bangalore
 */
public class Source {

    public static void findItinerary(Map<String, String> tickets) {
        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> entry : tickets.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        String start = null;
        for (Map.Entry<String, String> entry : tickets.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }
        if (start == null || start.equalsIgnoreCase("null")) {
            System.out.println("Invalid Input");
            return;
        }
        String current = start;
        while (tickets.containsKey(current)) {
            System.out.println(current + "->" + tickets.get(current));
            current = tickets.get(current);
        }
    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tickets.put(sc.next(),sc.next());
        }
        findItinerary(tickets);
    }
}