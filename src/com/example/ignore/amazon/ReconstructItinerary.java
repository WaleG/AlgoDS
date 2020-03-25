package com.example.ignore.amazon;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO"));
        List<String> path = new ReconstructItinerary().findItinerary(tickets);
        System.out.println(path);
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> g = constructGraph(tickets);
        LinkedList<String> path = new LinkedList<>();
        return dfs("JFK", path, g);
    }

    private LinkedList<String> dfs(String departure, LinkedList<String> path, Map<String, PriorityQueue<String>> g) {
        PriorityQueue<String> arrivals = g.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.remove(), path, g);
        }
        path.addFirst(departure);
        return path;
    }

    private Map<String, PriorityQueue<String>> constructGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        if (tickets == null) return g;
        for (List<String> edge : tickets) {
            g.computeIfAbsent(edge.get(0), v -> new PriorityQueue<>()).add(edge.get(1));
        }
        return g;
    }

    /*
     * Input: {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}
     * Output: {"JFK","ATL","JFK","SFO","ATL","SFO"}
     * Explanation: Another possible reconstruction is {"JFK","SFO","ATL","JFK","ATL","SFO"}.
     *              But it is larger in lexical order.
     */
}
