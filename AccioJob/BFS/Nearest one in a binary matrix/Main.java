// https://course.acciojob.com/idle?question=5ebeb2e9-0c47-4fd9-a7b9-5fbb1ecbe30b

import java.util.*;
import java.io.*;
class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
class Pair{
	int i;
	int j;
	int dis;
	Pair(int i, int j, int dis) {
		this.i = i;
        this.j = j;
        this.dis = dis;
	}
}
class Solution {
    public int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               if(grid[i][j] == 1){
                   q.add(new Pair(i, j, 0));
                }
            }
        }
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.i;
            int c = p.j;
            int dis = p.dis;

            ans[r][c] = dis;
            for(int i = 0; i < 4; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc, dis + 1));
                }
            }
        }
        return ans;
    }
}