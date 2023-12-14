package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11053_가장긴증가하는부분수열_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(brd.readLine());
        int[] num = new int[N+1];
        int[] dp = new int[N+1];
        Arrays.fill(dp, 1); //최솟값 1

        //수열 입력 받는다.
        StringTokenizer stn = new StringTokenizer(brd.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(stn.nextToken());
        }

        int ans = 1;

        for (int i = 2; i <= N ; i++) {
            for (int j = 1; j < i; j++) {
                if(num[i] > num[j] && dp[j] >= dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            //마지막 수를 포함할지 안할지 모르기때문에 for문 돌리면서 계속 업데이트해준다.
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
