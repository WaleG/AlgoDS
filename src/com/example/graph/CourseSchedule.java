package com.example.graph;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int num = 2;
        int[][] p = {{1, 0}};
        boolean canFinish = new CourseSchedule().canFinish(num, p);
        System.out.println(canFinish);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> g = new HashMap<>();
        buildGraph(indegree, prerequisites, g);
        return bfs(indegree, g, numCourses);
    }

    private boolean bfs(int[] indegree, Map<Integer, Set<Integer>> g, int numCourses) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                numCourses--;
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int n: g.get(curr)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    q.add(n);
                    numCourses--;
                    if (numCourses == 0) return true;
                }
            }
        }

        return numCourses == 0;
    }

    private void buildGraph(int[] indegree, int[][] prerequisites, Map<Integer, Set<Integer>> g) {
        for (int i = 0; i < indegree.length; i++) {
            g.putIfAbsent(i, new HashSet<>());
        }
        for (int[] edge : prerequisites) {
            indegree[edge[1]]++;
            g.get(edge[0]).add(edge[1]);
        }
    }
}
