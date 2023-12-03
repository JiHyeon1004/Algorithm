package boj.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj1926_그림_dfs {

    static int n, m, num, size, max;
    static int[][] pic;
    static boolean[][] check;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(brd.readLine());
        n = Integer.parseInt(stn.nextToken());
        m = Integer.parseInt(stn.nextToken());
        pic = new int[n][m];
        check = new boolean[n][m];
        max = 0;
        num = 0;

        // 그림 채우기
        for (int i = 0; i < n; i++) {
            stn = new StringTokenizer(brd.readLine());
            for (int j = 0; j < m; j++) {
                pic[i][j] = Integer.parseInt(stn.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && pic[i][j] == 1) {
                    size = 1;
                    check[i][j] = true;
                    num++;
                    dfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(num);
        System.out.println(max);

    }

    public static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !check[nr][nc] && pic[nr][nc] == 1) {
                check[nr][nc] = true;
                size++;
                dfs(nr, nc);
            }

        }
    }
}
