import java.util.*;

class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        int[] indegree = new int[n];

        // Count indegree of each node.
        for (int edge : edges) {
            if (edge != -1) {
                indegree[edge]++;
            }
        }

        // Kahn's algorithm starts.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (q.size() > 0) {
            int node = q.poll();
            visit[node] = true;
            int nbr = edges[node];
            if (nbr != -1) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }
        // Kahn's algorithm ends.

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                int nbr = edges[i];
                int count = 1;
                visit[i] = true;
                // Iterate in the cycle.
                while (nbr != i) {
                    visit[nbr] = true;
                    count++;
                    nbr = edges[nbr];
                }
                answer = answer > count ? answer : count;
            }
        }
        return answer;
    }
}