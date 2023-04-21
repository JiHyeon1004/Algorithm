package boj.silver3;

import java.util.Scanner;

// dp[n] = dp[n-1] + 2*dp[d-2]
public class Boj11762_2n타일링2_dp {

    static int[] tile;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        tile = new int[n + 1];
        //n이 1보다 작다면 그대로 내보내고 return
        if(n <= 1){
            System.out.println(n);
            return;
        }
        tile[1] = 1;
        tile[2] = 3;
        System.out.println(getDp(n));
    }

    static int getDp(int n) {
        if (n <= 2 || tile[n] != 0) {
            return tile[n];
        } else {
            tile[n] = (getDp(n - 1) + 2*getDp(n - 2)) % 10007;
            return tile[n];
        }

    }
}
