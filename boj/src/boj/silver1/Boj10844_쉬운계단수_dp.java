package boj.silver1;

import java.util.Scanner;

public class Boj10844_쉬운계단수_dp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long dp[][] = new long[N+1][10];
        int cnt = 2;

        //N=1일 때
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        //N=2 이상일 때
        if(N > 1){
            while(cnt <= N){

                for (int i = 0; i < 10; i++) {
                    if(i == 0){
                        dp[cnt][i] = dp[cnt-1][1] % 1000000000;
                    }
                    else if (i == 9){
                        dp[cnt][i] = dp[cnt-1][8] % 1000000000;
                    }
                    else{
                        dp[cnt][i] = (dp[cnt-1][i-1] + dp[cnt-1][i+1]) % 1000000000;
                    }
                }
                cnt++;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % 1000000000);

    }

}
