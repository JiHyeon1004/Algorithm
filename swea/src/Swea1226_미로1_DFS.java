package D4;

import java.util.Scanner;

public class Swea1226_미로1_DFS {
	// 지나온 길을 벽으로 바꾼다.

	static char[][] map;

	// 델타탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N = 16;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			map = new char[N][N];

			ans = 0;
			// 시작위치
			int stR = -1;
			int stC = -1;
			// 입력받는다.
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
				// 시작점도 찾아줌
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '2') {
						stR = i;
						stC = j;
					}
				}
			}
			// dfs돌려서 출력
			dfs(stR, stC);
			System.out.println("#" + tc + " " + ans);
		}
	}

	// dfs
	static void dfs(int r, int c) {
		// 1. 기본구간
		if (map[r][c] == '3') {
			ans = 1;
			return;
		}

		// 2. 순환구간
		map[r][c] = '1'; // 벽으로 바꾼다.
		// 델타탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 범위 밖이라면
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			// 벽이라면
			if (map[nr][nc] == '1') {
				continue;
			}
			dfs(nr, nc);
		}
	}
}
