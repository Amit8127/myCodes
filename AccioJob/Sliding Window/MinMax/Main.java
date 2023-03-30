// https://course.acciojob.com/idle?question=772447e9-d656-4ff0-827a-4926940541e4
// 

import java.util.*;
import java.io.*;

class Solution {

    public int minMax(int[] X, int[] Y, int[] Z) {
        // write code here
		int i = 0, j = 0, k = 0;
		int x = X.length, y = Y.length, z = Z.length;
		int diff = Integer.MAX_VALUE;
		int mini = Integer.MAX_VALUE;
		int maxi = Integer.MIN_VALUE;

		while(i < x && j < y && k < z) {
			mini = Math.min(X[i], Math.min(Y[j], Z[k]));
			maxi = Math.max(X[i], Math.max(Y[j], Z[k]));
			diff = Math.min(diff, maxi - mini);

			if(mini == X[i]) i++;
			else if(mini == Y[j]) j++;
			else k++;
		}
		return diff;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] X = new int[x];
        for (int i = 0; i < x; i++) {
            X[i] = sc.nextInt();
        }
        int y = sc.nextInt();
        int[] Y = new int[y];
        for (int i = 0; i < y; i++) {
            Y[i] = sc.nextInt();
        }
        int z = sc.nextInt();
        int[] Z = new int[z];
        for (int i = 0; i < z; i++) {
            Z[i] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.minMax(X, Y, Z));
    }
}