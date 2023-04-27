package boj.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class Boj17626_FourSquares_dp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, 4); //최대값이 4이므로
        dp[0] = 0;
        dp[1] = 1;


        for (int i = 2; i <= n; i++) {
            for(int j = 1; j*j <= i; j++){
                //i-j*j 번째의 최솟값에 가능한 j*j (1개) 를 더한 것과 최댓값인 4를 비교한다.
                dp[i] = Math.min(dp[i], (dp[i - j*j] + 1));
            }
        }

        System.out.println(dp[n]);
    }
}
