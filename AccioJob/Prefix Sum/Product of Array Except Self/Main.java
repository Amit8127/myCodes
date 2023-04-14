// https://course.acciojob.com/idle?question=f2ca55fd-3a7f-4a15-8e96-fd47960a21c9

import java.util.*;
public class Main {
	  public static void main(String[] args) throws Throwable {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();

	        int nums[]=new int[n];
	        for(int i = 0; i < n; i++)
	        {
	            nums[i] = sc.nextInt();
	        }
	        Solution obj = new Solution();
	        long ans[] = obj.ProductOfArrayExceptSelf(n,nums);
	        for(int i=0; i<n ; i++){
	            System.out.print(ans[i] + " ");
	        }
	    }
}
class Solution{
	public long[] ProductOfArrayExceptSelf(int n, int[] a){
		//write code here
		// Base case
        long prod[] = new long[n];
        if (n == 1) {
            return prod;
        }
 
        int i, temp = 1;
 
        /* Allocate memory for the product array */
 
        /* Initialize the product array as 1 */
        for (int j = 0; j < n; j++)
            prod[j] = 1;
 
        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= a[i];
        }
 
        /* Initialize temp to 1 for product on right side */
        temp = 1;
 
        /* In this loop, temp variable contains product of
           elements on right side excluding a[i] */
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= a[i];
        }
 
        return prod;
	}
}
