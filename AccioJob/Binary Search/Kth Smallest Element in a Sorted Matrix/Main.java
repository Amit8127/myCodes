// https://course.acciojob.com/idle?question=ca1bfbb8-a8f1-4736-9dac-578e50615064

import java.util.*;

class Solution{
	public int kthSmallest(int[][] matrix, int k) {
         int n = matrix.length;
        int l = matrix[0][0]; 
        int h = matrix[n-1][n-1];
        while(l <= h){
            int mid = l +(h-l)/2;
            int smallerOrEqual = getSmallerOrEqual(matrix,mid);
            if(smallerOrEqual>=k) h = mid-1;
            else
            l = mid+1;
        }
        return l;
    }
	private static int getSmallerOrEqual(int[][] a, int mid){
        int n = a.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(a[i][0] > mid) return ans;
            if(a[i][n-1] <= mid)
                ans += n;
            else{
                int temp = 0;
                int l = 0; 
                int h=n-1;
                while(l<=h){
                    int m = l + (h-l)/2; 
                    if(a[i][m] <= mid){
                        temp = m;
                        l = m+1;
                    }else
                        h = m-1;
                }
                ans += temp +1;
            }
        }
        return ans;
    } 
}

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    mat[i][j] = sc.nextInt();
            }
        
            Solution obj=new Solution();
            System.out.println(obj.kthSmallest(mat, sc.nextInt()));
        }
    }

}