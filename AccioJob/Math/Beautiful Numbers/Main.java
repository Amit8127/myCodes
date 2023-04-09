// https://course.acciojob.com/idle?question=3371df0b-df51-42c0-b0ca-e908eb7a031f

import java.util.Scanner;

class Solution{
    public static void solve(int n, int[] arr) {
       // Your code here
        int[] mp = new int[n + 1];
        for(int i = 0; i < n; i++){
            mp[arr[i]] = i;
        }
        int lo = n;
        int hi = 0;
        String ans = "";
        for(int i = 1; i <= n; i++){
            lo = Math.min(lo, mp[i]);
            hi = Math.max(hi, mp[i]);

            if(hi - lo + 1 == i) ans+= "1";
            else ans+= "0";
        }
        System.out.println(ans);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Solution.solve(n, arr);
        scanner.close();
    }
}
