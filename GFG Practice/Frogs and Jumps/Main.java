
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;

class Main {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            
            String inputLine1[] = br.readLine().trim().split(" "); 
            int i=0;
            int N = Integer.parseInt(inputLine1[i++]);
            int leaves = Integer.parseInt(inputLine1[i++]);
            
            int frogs[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                frogs[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.unvisitedLeaves(N, leaves, frogs));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        boolean leave[] = new boolean[leaves + 1];
        
        for(int i : frogs) {
            if(i <= leaves && leave[i] == false) {
                for(int j = i; j <= leaves; j += i) {
                    leave[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i = 1; i <= leaves; i++) {
            if(leave[i] == false) {
                count++;
            }
        }
        return count;
    }
}
