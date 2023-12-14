package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class test {

}

class Solution {
    static Vector<Vector<Integer>> adj;
    static boolean[] visited;
    static int num;

    public int journeyToMoon(int n, int[][] astronaut) {
        adj = new Vector<Vector<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new Vector<Integer>());
        }
        for (int i = 0; i < 2; i++) {
            adj.get(astronaut[i][0]).add(astronaut[i][1]);
            adj.get(astronaut[i][1]).add(astronaut[i][0]);
        }
        visited = new boolean[n];
        Arrays.fill(visited, false);
        Vector<Integer> v = new Vector<Integer>();
        num = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                v.add(num);
                num = 0;
            }
        }
        int ans = n * (n - 1) / 2 + 1;
        for (int i = 0; i < v.size(); i++) {
            ans -= (v.get(i) * (v.get(i) - 1) / 2) + 1;
        }
        return ans;
    }

    void dfs(int v) {
        visited[v] = true;
        num++;
        for (int i = 0; i < adj.get(v).size(); i++) {
            if (!visited[adj.get(v).get(i)]) {
                dfs(adj.get(v).get(i));
            }
        }
    }
}

class Solutions {

    static Set<Integer> countryOne = new HashSet();
    static Set<Integer> countryTwo = new HashSet();
    static Set<Integer> countryNone = new HashSet();

    public int journeyToMoon(int n, int[][] astronaut) {

        /// Separating diffrent country from input
        countryOne.add(astronaut[0][0]);
        countryOne.add(astronaut[0][1]);
        for (int i = 1; i < astronaut.length; i++) {
            boolean countryCheckFlag = false;
            for (int j = 0; j < astronaut[i].length; j++) {
                if (countryOne.contains(astronaut[i][j])) {
                    countryCheckFlag = true;
                }
            }
            if (countryCheckFlag) {
                countryOne.add(astronaut[i][0]);
                countryOne.add(astronaut[i][1]);
            } else {
                countryTwo.add(astronaut[i][0]);
                countryTwo.add(astronaut[i][1]);
            }
        }

        /// Separating country which not present in input
        for (int i = 0; i < n; i++) {
            if (!countryOne.contains(i) && !countryTwo.contains(i))
                countryNone.add(i);
        }

        // Now i have two diffrent set
        int x = countryNone.size();
        return (x * x - x) / 2;
        // return countryOne.size() * countryTwo.size();

    }
}