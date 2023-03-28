// https://course.acciojob.com/idle?question=f2de87a9-3254-4fad-a157-e5194ac90f1c

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static long reverse(long A) {
	    // Your code here
		long result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // left shift result by 1 bit
            if ((A & (1 << i)) != 0) { // if ith bit is 1
                result |= 1; // set the rightmost bit of result to 1
            }
        }
        return result;
	}
}
public class Main {
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    	long n = sc.nextLong();
			System.out.println(Solution.reverse(n));
            sc.close();
	}
}