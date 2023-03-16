package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2468_안전영역_DFS {

    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int maxArea = 1; //잠기지 않을 때

        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        N = Integer.parseInt(brd.readLine());
        map = new int[N][N];

        //강수량
        int min = 100;
        int max = 1;

        //지도 입력
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(brd.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
                if (map[i][j] < min) {
                    min = map[i][j];
                }
            }
        }


        //비에 양에 따라 돌린다.
        for (int i = min; i < max; i++) {
            check = new boolean[N][N];
            //지역별로 돌린다.
            int area = 0; //안전지대의 개수

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!check[j][k] && map[j][k] > i) { //방문한 적 없고 지대가 강수량보다 높다면
                        check[j][k] = true; //방문체크
                        area++; //안전지대의 개수 증가
                        dfs(i, j, k); //연결된 곳 확인
                    }
                }
            }
            maxArea = Math.max(area, maxArea); //최대 개수 갱신
        }

        System.out.println(maxArea);
    }


    //dfs (연결된 안전지대 조사)
    public static void dfs(int rain, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !check[nr][nc] && map[nr][nc] > rain) {
                check[nr][nc] = true;
                dfs(rain, nr, nc);
            }
        }
    }
}
