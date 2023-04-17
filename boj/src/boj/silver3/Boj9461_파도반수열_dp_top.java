package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//dp[n] = dp[n-3] + dp[n-2];
public class Boj9461_파도반수열_dp_top {

    static long[] dp = new long[101]; //변의 길이 메모이제이션

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(brd.readLine()); //테스트케이스

        //초기화
        Arrays.fill(dp, -1);
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(brd.readLine());
            System.out.println(getLength(N));
        }

    }

    static long getLength(int n){
        if(dp[n] == -1){
            dp[n] = getLength(n-3) + getLength(n-2);
        }
        return dp[n];
    }
}
