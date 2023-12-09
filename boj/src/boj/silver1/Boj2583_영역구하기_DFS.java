package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2583_영역구하기_DFS {

    static int N, M, K, cnt, size;
    static boolean[][] square;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(brd.readLine());
        M = Integer.parseInt(stn.nextToken()); // 세로
        N = Integer.parseInt(stn.nextToken()); //가로
        K = Integer.parseInt(stn.nextToken()); //직사각형의 수
        cnt = 0;
        StringBuilder sbd = new StringBuilder();
        PriorityQueue<Integer> sizes = new PriorityQueue<>(); //사이즈의 집합

        square = new boolean[M][N];


        // K개의 직사각형
        for (int i = 0; i < K; i++) {
            stn = new StringTokenizer(brd.readLine());
            int x1 = Integer.parseInt(stn.nextToken());
            int y1 = Integer.parseInt(stn.nextToken());
            int x2 = Integer.parseInt(stn.nextToken());
            int y2 = Integer.parseInt(stn.nextToken());

            //직사각형 색칠하기
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    square[j][k] = true;
                }
            }
        }


        //dfs돌리기
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (!square[j][k]) {
                    square[j][k] = true;
                    cnt++;
                    size = 1;
                    dfs(j, k);
                    sizes.add(size);
                }
            }
        }

        //출력
        sbd.append(cnt).append("\n");
        for (int i = 0; i < cnt; i++) {
            sbd.append(sizes.poll() + " ");
        }

        System.out.println(sbd.toString());

    }

    //dfs
    private static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N && !square[nr][nc]) {
                square[nr][nc] = true;
                size++;
                dfs(nr, nc);
            }

        }
    }


}
