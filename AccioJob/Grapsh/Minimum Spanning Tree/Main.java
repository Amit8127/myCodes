// https://course.acciojob.com/idle?question=b676f879-c0b8-4cf6-b2ba-6e896496cb94

import java.util.*;

public class Main {

	static int minKey(int[] key, boolean[] mst, int V) {
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for(int i = 0; i < V; i++) {
			if(mst[i] == false && key[i]  < min) {
				min = key[i];
				idx = i;
			}
		}
		return idx;
	}
	static int primMST(int graph[][], int V) {
	// your code here
		boolean[] mst = new boolean[V];
		int[] key = new int[V];
		int[] parent = new int[V];
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);

		key[0] = 0;
		
		for(int k = 0; k < V; k++) {
			int i = minKey(key, mst, V);
			mst[i] = true;
			for(int j = 0; j < V; j++) {
				if(graph[i][j] != 0 && mst[j] == false && graph[i][j] < key[j]) {
					key[j] = graph[i][j];
					parent[j] = i;
				}
			}
		}
		int ans = 0;
		for(int i = 1; i < V; i++) {
			ans += graph[parent[i]][i];
		}
		return ans;
	}

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vertices = sc.nextInt(), edges = sc.nextInt();
    int[][] graph = new int[vertices][vertices];
    for (int i = 0; i < edges; i++) {
      int src = sc.nextInt(), dest = sc.nextInt(), dist = sc.nextInt();
      graph[src][dest] = dist;
      graph[dest][src] = dist;
    }
    sc.close();

    System.out.println(primMST(graph, vertices));
  }
}