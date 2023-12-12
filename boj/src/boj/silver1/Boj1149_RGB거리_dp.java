package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//모든 경로의 경우의 수를 찾아서 최종적으로 가장 작은 누적합 찾아야함.
//현재 빨간색을 칠하는 경우 : dp[n][R] = Math.min(dp[n-1][G], dp[n-1][B]) + price[n][R];
//현재 초록색을 칠하는 경우 : dp[n][G] = Math.min(dp[n-1][R], dp[n-1][B]) + price[n][G];
//현재 파란색을 칠하는 경우 : dp[n][B] = Math.min(dp[n-1][R], dp[n-1][G]) + price[n][B];
public class Boj1149_RGB거리_dp {

    static int[][] dp, price;

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;

        int N = Integer.parseInt(brd.readLine());
        //R : 0, G : 1, B : 2
        dp = new int[N+1][3];
        price = new int[N+1][3];

        for (int i = 0; i < N; i++) {
            stn = new StringTokenizer(brd.readLine());
            price[i+1][0] = Integer.parseInt(stn.nextToken());
            price[i+1][1] = Integer.parseInt(stn.nextToken());
            price[i+1][2] = Integer.parseInt(stn.nextToken());
        }

        dp[1][0] = price[1][0];
        dp[1][1] = price[1][1];
        dp[1][2] = price[1][2];

        System.out.println(Math.min(getDp(N, 0), Math.min(getDp(N, 1), getDp(N, 2))));
    }

    static int getDp(int n, int i){
        if(dp[n][i] != 0){
            return dp[n][i];
        }
        //red
        if(i == 0){
            dp[n][0] = Math.min(getDp(n-1, 1), getDp(n-1, 2)) + price[n][0];
        }
        //green
        if(i == 1){
            dp[n][1] = Math.min(getDp(n-1, 0), getDp(n-1, 2)) + price[n][1];
        }
        //blue
        if(i == 2){
            dp[n][2] = Math.min(getDp(n-1, 0), getDp(n-1, 1)) + price[n][2];
        }
        return dp[n][i];
    }
}
