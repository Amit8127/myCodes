// https://course.acciojob.com/idle?question=394beaf0-a22e-4e5d-81ca-9b29ea03f57e

import java.util.*;
public class Main {
	   public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] trips = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    trips[i][j] = sc.nextInt();
                }
            }
            int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
        //your code
		int[] point = new int[1005];

        for (int[] trip : trips) {
            int noOfPass = trip[0];
            int sp = trip[1];
            int ep = trip[2];
            point[sp] += noOfPass;
            point[ep - 1] -= noOfPass;
        }

		for(int i = 1; i < 1005; i++) {
			point[i] += point[i - 1];
		}

		for(int i = 0; i < 1005; i++) if(point[i] > capacity) return false;
		return true;
	}
}