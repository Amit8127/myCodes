// https://course.acciojob.com/idle?question=edd1121c-c07c-41db-b1d1-685dd1ed160e

import java.util.*;

class Solution {
    
    public static void minSubArrayLen(int arr[], int target, int n) {
        //Write your code here
        int ans = Integer.MAX_VALUE, i = 0, j = 0, sum = 0;

		while(j < n && i <= j) {
			sum += arr[j];
			while(sum > target) {
				ans = Math.min(ans, j - i + 1);
				sum -=arr[i];
				i++;
			}
			j++;
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Solution.minSubArrayLen(arr,target,n);
        sc.close();
    }
}
