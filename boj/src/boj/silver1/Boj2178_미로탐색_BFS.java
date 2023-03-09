package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178_미로탐색_BFS {

    static int N, M, ans;
    static int[][] maze;
    static boolean[][] check;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Pos cycle; //한 사이클 돌 때 마다 추가할 객체

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로(행)
        M = Integer.parseInt(st.nextToken()); //가로(열)

        maze = new int[N + 2][M + 2]; //사방으로 벽 한 줄 추가 -> 나중에 범위 확인 안하려고 ㅎ
        check = new boolean[N + 2][M + 2];

        //미로 채워넣기
        for (int i = 1; i <= N; i++) {
            char[] info = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = info[j-1] - '0';
            }
        }
        ans = 1; //시작점도 포함
        Pos start = new Pos(1, 1); //시작점의 위치
        cycle = new Pos(-1, -1); //사이클 돌 때 마다 추가할 객체

        BFS(start);

        System.out.println(ans);

    }

    //위치를 통해 BFS 돌린다.
    static void BFS(Pos pos) {
        Queue<Pos> route = new LinkedList<>();
        route.add(pos);
        route.add(cycle);

        while (!route.isEmpty()) {
            Pos now = route.poll();
            //도착했으면 리턴
            if (now.r == N && now.c == M) {
                return;
            } else if (now.equals(cycle)) {
                ans++;
                route.add(cycle);
            } else {
                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    if (maze[nr][nc] == 1 && !check[nr][nc]) {
                        check[nr][nc] = true;
                        Pos newP = new Pos(nr, nc);
                        route.add(newP);
                    }
                }
            }
        }

    }

    //위치 정보
    public static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
