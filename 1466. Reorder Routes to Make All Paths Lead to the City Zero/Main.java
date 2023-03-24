public class Main {
    class Solution {
        public int minReorder(int n, int[][] connections) {
            Set<String> st = new HashSet<>();
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] road : connections) {
    
                st.add(road[0] + "," + road[1]);
                map.computeIfAbsent(road[0], k -> new HashSet<>());
                map.computeIfAbsent(road[1], k -> new HashSet<>());
                map.get(road[0]).add(road[1]);
                map.get(road[1]).add(road[0]);
            }
            
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            int ans = 0;
            boolean[] vs = new boolean[n];
            vs[0] = true;
            while (q.size() > 0) {
                int road = q.poll();
                for (int next : map.getOrDefault(road, new HashSet<>())) {
                    if (vs[next]) continue;
                    vs[next] = true;
                    if (st.contains(next + "," + road) == false) 
                        ans++;
                    q.offer(next);
                }
            }
            return ans;
        }
    }
}
