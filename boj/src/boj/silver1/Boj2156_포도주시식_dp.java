package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2156_포도주시식_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine()); //포도주 잔의 개수
        int[] wine = new int[n];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(bufferedReader.readLine());
        }

        //dp
        long[] dp = new long[n];
        dp[0] = wine[0];

        //포도주가 2잔 이상이라면
        if (n > 1) {
            dp[1] = dp[0] + wine[1];

            //포도주가 3잔 이상이라면
            if (n > 2) {
                dp[2] = Math.max((wine[0] + wine[1]), Math.max((wine[1] + wine[2]), wine[0] + wine[2]));

                //해당 와인잔을 선택하지 않는 경우, 해당 와인잔 앞을 건너뛰는 경우, 해당 와인잔 앞부터 연속해서 마실 경우
                for (int i = 3; i < n; i++) {
                    dp[i] = Math.max((dp[i - 1]), Math.max((dp[i - 2] + wine[i]), (dp[i - 3] + wine[i - 1] + wine[i])));
                }
            }

        }

        System.out.println(dp[n - 1]);

    }
}
