// https://course.acciojob.com/idle?question=684c8b48-2f55-4231-ad3d-dcdaced93923

import java.io.*;
import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        //write code here

		int n = prices.length;
		int ans[] = new int[n];

		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < n; i++) {

            while (st.size() > 0 && prices[st.peek()] >= prices[i]) {
                int idx = st.pop();
                ans[idx] = prices[idx] - prices[i];
            }
			st.push(i);
		}  

		while(st.size() > 0) {
			int idx = st.pop();
			ans[idx] = prices[idx];
		}

		return ans;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        int[] res = obj.finalPrices(arr);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
        System.out.println();
        sc.close();
    }
}
