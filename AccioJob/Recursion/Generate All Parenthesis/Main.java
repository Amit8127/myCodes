import java.util.*;
class Solution{
	public void healper(int n, int i, int j, String ans) {
		if(i == n && j == n) {
			System.out.println(ans);
			return;
		}
		if(i < n)
		healper(n, i + 1, j, ans + "(");
		if(i > j)
		healper(n, i, j + 1, ans + ")");
		
	}
     public void generateParanthesis(int n){
        // write code here
		 healper(n, 0, 0, "");
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.generateParanthesis(n);
        input.close();
    }
}