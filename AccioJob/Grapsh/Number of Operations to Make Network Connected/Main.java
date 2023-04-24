// https://course.acciojob.com/idle?question=8ece7d1c-895e-4584-b084-64f1032d0611

import java.util.*;
class DSU {
	int[] parent;
	public DSU(int n) {
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	int find(int x) {
		if(x == parent[x]) return x;
		return find(parent[x]);
	}
	void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
}
class Solution{
    
    public static int makeConnected(int n , int[][] connections){
        //write your code here
        int m = connections.length;
		if(m < (n - 1)) return -1;
		DSU d = new DSU(n);
		int ans = n;
		for(int[] edge : connections) {
			int x = edge[0];
			int y = edge[1];
			if(d.find(x) != d.find(y)) {
				d.union(x,y);
				ans--;
			}
		}
		return ans - 1;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][2] ; 
        for(int i = 0 ; i < m ; ++i){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.print(Solution.makeConnected(n,edges));
    }
}