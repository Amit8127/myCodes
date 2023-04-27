// https://course.acciojob.com/idle?question=05f7c96a-217f-4020-a369-35070a1890db

import java.util.*;

class Solution {
    static int miniNumSwaps(String brackets, int n) {
        // write code here
		char[] chars = brackets.toCharArray();
        
        // stores total number of Left and Right
        // brackets encountered
        int countLeft = 0, countRight = 0;
        // swap stores the number of swaps required
        //imbalance maintains the number of imbalance pair
        int swap = 0 , imbalance = 0;
         
        for(int i =0; i< chars.length; i++){
            if(chars[i] == '('){
                // increment count of Left bracket
                countLeft++;
                if(imbalance > 0){
                    // swaps count is last swap count + total
                    // number imbalanced brackets
                    swap += imbalance;
                    // imbalance decremented by 1 as it solved
                    // only one imbalance of Left and Right
                    imbalance--;    
                }
            } else if(chars[i] == ')' ){
                // increment count of Right bracket
                countRight++;
                // imbalance is reset to current difference
                // between Left and Right brackets
                imbalance = (countRight-countLeft);
            }
        }
        return swap;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String brackets = sc.next();
        int ans = Solution.miniNumSwaps(brackets, n);
        System.out.println(ans);
    }
}
