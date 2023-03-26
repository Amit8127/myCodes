import java.util.*;

class Solution {
    public int FlipFlip(int n, int[] A,int K) {
        // Write your code here
		int flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
         int k = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
		int a=Obj.FlipFlip(n,arr,k);
        System.out.print(a+" ");
		}
}
