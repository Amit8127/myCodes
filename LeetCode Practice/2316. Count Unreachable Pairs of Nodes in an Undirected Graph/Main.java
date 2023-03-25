class Solution {

    public int bfs(int i,boolean[] vis,List<List<Integer>> nbr,int count){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        count++;
        while(q.size() > 0){
            int curr = q.poll();
            for(int adjnode:nbr.get(curr)){
                if(vis[adjnode] == false){
                    q.add(adjnode);
                    count++;
                    vis[adjnode] = true;
                }
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> nbr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nbr.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            nbr.get(edges[i][0]).add(edges[i][1]);
            nbr.get(edges[i][1]).add(edges[i][0]);
        }
        long sum = n;
        long res = 0;
        boolean vis[]=new boolean[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                vis[i] = true;
                int count = bfs(i, vis, nbr, 0);
                sum -= count;
                res += (sum * count);
            }
        }
        return res;
    }
}