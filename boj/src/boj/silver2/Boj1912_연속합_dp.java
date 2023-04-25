package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1912_연속합_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(brd.readLine()); //숫자의 개수
        int[] num = new int[n+1]; //입력받은 숫자 배열
        int[] dp = new int[n+1]; //해당 인덱스 번째 숫자까지의 최대 연속합을 저장

        //숫자 입력
        String[] seq = brd.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(seq[i-1]);
        }

        int ans = num[1]; //답은 1번째 항으로 초기화
        dp[1] = num[1];

        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i-1] + num[i], num[i]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }
}
