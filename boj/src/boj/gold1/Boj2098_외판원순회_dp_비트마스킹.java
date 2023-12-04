package boj.gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//비트마스킹을 이용하여 방문한 도시를 표시한다.
//어느 도시에서 출발하던 경로가 같다면 비용이 같다.
//따라서 0에서 출발하도록 지정해버린다.
public class Boj2098_외판원순회_dp_비트마스킹 {

    static int N;
    static final int INF = 200000000;
    static int[][] W, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn;

        N = Integer.parseInt(brd.readLine());
        W = new int[N][N];
        //지도 채우기
        for (int i = 0; i < N; i++) {
            stn = new StringTokenizer(brd.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(stn.nextToken());
            }
        }

        //dp 정의
        dp = new int[N][(1<<N)-1]; //[현재 도시][지금까지 방문한 도시]

        System.out.println(dfs(0, 1));

    }

    static int dfs(int now, int visit){
        //모두 다 순회했다
        if(visit == (1<<N)-1){
            //출발지로 돌아가는 경로가 있으면 간다.
            if(W[now][0] != 0){
                return W[now][0];
            }
            //없으면 INF리턴
            return INF;
        }
        //메모라이제이션이 되어있다면 고대로 사용한다.
        if(dp[now][visit] != 0){
            return dp[now][visit];
        }

        //아직 순회중이고 메모라이제이션이 안되어있다면
        //우선 dp를 큰 수로 초기화한다.
        dp[now][visit] = INF;
        for (int i = 0; i < N; i++) {
            //i번째 도시에 아직 방문하지 않았고, 경로가 존재한다면
            if((visit & (1<<i)) != (1<<i) && W[now][i] != 0){
                //방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발로 가는 최소 비용 + 여기서 다음도시까지 비용
                //즉, (다음도시 -> 그 다음도시) + (현재도시 -> 다음도시)
                dp[now][visit] = Math.min(dfs(i, visit | (1<<i)) + W[now][i], dp[now][visit]);
            }
        }
        return dp[now][visit];
    }


}
