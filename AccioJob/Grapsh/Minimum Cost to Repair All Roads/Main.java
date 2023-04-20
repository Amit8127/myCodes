// https://course.acciojob.com/idle?question=740c2217-81de-472e-ab2f-061ad8bff051

import java.util.*;

class Solution {
	private int min(int[] keyval, boolean[] vis) {
		int min = Integer.MAX_VALUE;
		int idx = 0;

		for(int i = 0; i < keyval.length; i++) {
			if(vis[i] == false && keyval[i] < min) {
				min = keyval[i];
				idx = i;
			}
		}
		return idx;
	}
    public int MinCost(int[][] cost, int n) {
        // Write your code here
		int parent[] = new int[n];
		int keyval[] = new int[n];
		boolean vis[] = new boolean[n];
		
		Arrays.fill(keyval, Integer.MAX_VALUE);
		parent[0] = -1;
		keyval[0] = 0;

		for(int i = 0; i < n - 1; i++) {
			int c = min(keyval, vis);
			vis[c] = true;
			for(int j = 0; j < n; j++) {
				if(cost[c][j] > 0 && vis[j] == false && cost[c][j] < keyval[j]) {
					keyval[j] = cost[c][j];
					parent[j] = c;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < n; i++)
			ans += keyval[i];
         
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] c = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                c[i][j] = sc.nextInt();
        }

	    Solution Obj = new Solution();
        System.out.println(Obj.MinCost(c, n));
    }
}