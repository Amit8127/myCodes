// https://course.acciojob.com/idle?question=9af07aa6-8553-4c43-bd37-83bff306832a

import java.util.*;
public class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int k=sc.nextInt();
				Solution ob =new Solution();
				String ans = ob.smallestNumber(n,k);
				System.out.println(ans);
				t--;
			}
		}
	}

}

class Solution{ 
    public String smallestNumber(int S, int D){
        //Write code here
		if(S == 0 && D == 1) return "-1";
		if(S > 9 * D) return "-1";

		int[] res = new int[D];
		S -= 1;

		for(int i = D - 1; i > 0; i--) {
			if (S > 9) {
                res[i] = 9;
                S -= 9;
            } else {
                res[i] = S;
                S = 0;
            }
		}
		res[0] = S + 1;

		String ans = "";
		for (int i = 0; i < D; i++)
            ans += res[i];

		return ans;
    }
}