package SumOfToNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int sum  = n + m;
        
        System.out.println(sum);
        scn.close();
    }
}
