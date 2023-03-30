// https://course.acciojob.com/idle?question=0ac2a668-c546-4d0a-9952-dece48e292fd

import java.util.*;

public class Main {
	static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] island = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                island[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(islandPerimeter(island));
    }

    public static int islandPerimeter(int[][] grid) {
        // your code here
		int i = 0, j = 0, n = grid.length, m = grid[0].length;
		boolean flag = false;
		for(i = 0; i < n; i++) {
			for(j = 0; j < m; j++) {
				if(grid[i][j] == 1) {
					flag = true;
					break;
				}
			}
			if(flag == true) break;
		}
		dfs(grid, i, j);
		return ans;
    }
	public static void dfs(int[][] grid, int i, int j) {
		int n = grid.length, m = grid[0].length;

		if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || grid[i][j] == -1) return;

		if(grid[i][j] == 1) {
			ans += count(grid, i + 1, j) +count(grid, i - 1, j) + count(grid, i, j + 1)+count(grid, i, j - 1);
			grid[i][j] = -1;
		}
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
	public static int count (int[][] grid, int i, int j) {
		int n = grid.length, m = grid[0].length;
		if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) return 1;
		else return 0;
	}
}