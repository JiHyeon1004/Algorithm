package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//컨설팅 소요일이 t일 때
//t일이 지난 후 수입은
//t일이 지난 후 dp값과 vs 현재 컨설팅 금액 + 지금까지 쌓인 금액
// dp[consulting[i][0] + i] = Math.max(dp[consulting[i][0] + i], consulting[i][1] + dp[i]);
public class Boj14501_퇴사_dp {


    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;

        int N = Integer.parseInt(brd.readLine());
        int[][] consulting = new int[N + 1][2]; //1열은 소요일수, 2열은 금액
        int[] dp = new int[N + 2];
//        int max = 0;


        for (int i = 1; i <= N; i++) {
            stn = new StringTokenizer(brd.readLine());
            consulting[i][0] = Integer.parseInt(stn.nextToken()); //소요일
            consulting[i][1] = Integer.parseInt(stn.nextToken()); //금액
        }

        for (int i = 1; i <= N; i++) {
            if((i + consulting[i][0]) <= N+1){
                dp[i+consulting[i][0]] = Math.max(dp[consulting[i][0] + i], consulting[i][1] + dp[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N+1]);
    }

}
