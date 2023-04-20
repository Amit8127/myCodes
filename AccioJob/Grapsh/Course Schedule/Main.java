// https://course.acciojob.com/idle?question=98332447-d28d-42ee-9843-3d4d9d5ea20d

import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")

	Set<Integer> set = new HashSet();
	
	public int DFS(int [] count,ArrayList<Integer> [] prereqs, int currentClass, int n)
    {
        set.add(currentClass);
        n--;
        if(prereqs[currentClass].size() == 0)
        {
            return n;
        }
        for(int neighbor : prereqs[currentClass])
        {
            count[neighbor]--;
            if(count[neighbor] == 0)
            {
                if(!set.contains(neighbor))
            {
                n = DFS(count, prereqs, neighbor, n);
            }
            }
        }
        return n;
    }
	
    public int canFinish(int n, int[][] prerequisites) {
        //write your code here
		int [] count = new int[n];
        ArrayList<Integer> [] prereqs = new ArrayList[n];
        for(int k = 0; k < n; k++)
        {
            prereqs[k] = new ArrayList();
        }
        
        for(int [] temp : prerequisites)
        {
            int a = temp[0];
            int b = temp[1];
            count[a]++;
            prereqs[b].add(a);
        }


        for(int k = 0; k < count.length; k++)
        {
            if(!set.contains(k))
            {
                if(count[k] == 0)
                {
                n = DFS(count, prereqs, k, n);
                }
            }
        }

        return n == 0 ?  1 : 0;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}