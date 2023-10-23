package boj.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11060_점프점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        
        int[] A = new int[N];
        int[] dp = new int[N]; //해당 위치로 갈 수 있는 최소 점프 수
        Arrays.fill(dp, 1001); //dp를 최대로 만들어둔다.
        dp[0] = 0;

        //A채우기
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }


        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < i + A[i] + 1 && j < N; j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }

        if(dp[N-1] != 1001){
            System.out.println(dp[N-1]);
        }
        else{
            System.out.println(-1);
        }

    }
}
