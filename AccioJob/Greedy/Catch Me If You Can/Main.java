// https://course.acciojob.com/idle?question=16b4c5a1-feb5-48ea-a853-257ca1a7d864

import java.util.*;

class Accio{
    static int CatchMeIfYouCan(int n, int k, int[] arr){
        // write code here
		int police = 0;
		Arrays.sort(arr);
		int count = 0; 
		for(int i = k - 1; i >= 0 && police < arr[i]; i--){
			count++; 
			police += n - arr[i];
		} 
		return count;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] x = new int[k];
        for(int i=0;i<k;++i){
            x[i] = sc.nextInt();
        }
        Accio obj = new Accio();
        int ans=obj.CatchMeIfYouCan(n,k,x);
        System.out.println(ans);
    }
}