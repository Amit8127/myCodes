// https://course.acciojob.com/idle?question=c8fc7c7c-ae34-4fbe-909d-a7d666d4510a

import java.util.*;

class Solution {

    public int constantPalindrome(int arr[], int k) {
        // write code here
        return 0;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        sc.close();
        System.out.print(Obj.constantPalindrome(arr, k));
    }
}