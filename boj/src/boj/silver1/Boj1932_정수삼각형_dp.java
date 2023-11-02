package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932_정수삼각형_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] tri = new int[n][n]; //삼각형
        long[][]dp = new long[n][n]; //dp

        //삼각형 채운다.
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[0][0] = tri[0][0]; //초기화
        long max = dp[0][0]; //삼각형의 크기가 1인 경우를 대비
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j >= 1){
                    dp[i][j] = tri[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                    if(i == n-1){
                        max = Math.max(max, dp[i][j]);
                    }
                }
                else{
                    dp[i][j] = tri[i][j] + dp[i-1][j];
                    if(i == n-1){
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }

        System.out.println(max);

    }
}
