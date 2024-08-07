package SecureRouteForPrimeMinister.Part2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Road {
    public String city1;
    public String city2;
    public int safetyScore;

    public Road(String city1, String city2, int safetyScore) {
        this.city1 = city1;
        this.city2 = city2;
        this.safetyScore = safetyScore;
    }
}

class RoadMap {
    Map<String, Set<Road>> roadMap = new HashMap<String, Set<Road>>();

    public Set<String> getAllCities() {
        return this.roadMap.keySet();
    }

    public void readLine(String line) {
        String[] csv = line.split(",");
        String city1 = csv[0];
        String city2 = csv[1];
        int safety = Integer.parseInt(csv[2]);
        addRoad(city1, city2, safety);
    }

    private void addCity(String city) {
        this.roadMap.put(city, new HashSet<Road>());
    }

    private void addRoad(String city1, String city2, int safetyScore) {
        Road road1 = new Road(city1, city2, safetyScore);
        Road road2 = new Road(city2, city1, safetyScore);
        if (!this.roadMap.containsKey(city1)) {
            addCity(city1);
        }
        if (!this.roadMap.containsKey(city2)) {
            addCity(city2);
        }

        this.roadMap.get(city1).add(road1);
        this.roadMap.get(city2).add(road2);
    }

    public Set<Road> getAllOutgoingRoads(String node) {
        return this.roadMap.get(node);
    }

}

class GraphAssignment {

    static RoadMap roadMap = new RoadMap();
    static int maxValue = 100000;

    private static void relax(Road road, Map<String, Integer> safety, Map<String, String> safetyPath) {
        int possible = safety.get(road.city1) + road.safetyScore;
        if (safety.get(road.city2) > possible) {
            safety.put(road.city2, possible);
            safetyPath.put(road.city2, road.city1);
        }
    }

    static class SafetyComparator implements Comparator<String> {
        private final Map<String, Integer> safety;

        public SafetyComparator(Map<String, Integer> safety) {
            this.safety = safety;
        }

        public int compare(String c1, String c2) {
            if (this.safety.get(c1) < this.safety.get(c2)) {
                return -1;
            } else if (this.safety.get(c1) > this.safety.get(c2)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void readReport(Scanner scanner) {
        while (true) {
            String mapLine = scanner.nextLine();
            if (mapLine.equals("")) {
                break;
            }
            roadMap.readLine(mapLine);
        }
        System.out.println("Read report");

    }

    // PART-B: Applying Dijkstra algorithm to find the route with the lowest safetyRisk
    public static void findSafestRouteToCity(String source, String destination) {
        Map<String, Integer> safety = new HashMap<String, Integer>();
        Map<String, String> safetyPath = new HashMap<String, String>();
        for (String city : roadMap.getAllCities()) {
            safety.put(city, maxValue);
        }

        safety.put(source, 0);
        String nextCity = source;
        for (Road road : roadMap.getAllOutgoingRoads(nextCity)) {
            relax(road, safety, safetyPath);
        }
        PriorityQueue<String> queue = new PriorityQueue<String>(11, new SafetyComparator(safety));
        for (String c : roadMap.getAllCities()) {
            queue.add(c);
        }
        while (!queue.isEmpty()) {
            queue.poll();
            nextCity = queue.peek();
            if (nextCity != null) {
                for (Road road : roadMap.getAllOutgoingRoads(nextCity)) {
                    relax(road, safety, safetyPath);
                }
            }
        }

        if (safety.get(destination) == maxValue) {
            System.out.println("Not Recommended");
        } else {
            String currentCity = destination;
            String safestPath = destination;
            while (!currentCity.equals(source)) {
                currentCity = safetyPath.get(currentCity);
                safestPath = currentCity + " -> " + safestPath;
            }
            System.out.println(safestPath);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        readReport(scanner);
        findSafestRouteToCity("Indore", "Mumbai");

    }

}
