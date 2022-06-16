package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea1226_미로1_BFS {
	// 방문처리

	// inner class로 position을 정의한다.
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static char[][] map; // 맵 배열

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
			Pos st = null; // 시작점
			// 입력받는다.
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
				// 시작점 찾아준다.
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '2') {
						st = new Pos(i, j);
					}
				}
			}

			// 방문처리할 배열
			boolean[][] visited = new boolean[N][N];

			// 큐 생성
			Queue<Pos> queue = new LinkedList<>();
			// 시작점을 넣고 방문처리
			queue.add(st);
			visited[st.r][st.c] = true;

			// 큐가 빌 때까지 돌려라
			while (!queue.isEmpty()) {
				Pos curr = queue.poll();

				// 도착점이라면 끝
				if (map[curr.r][curr.c] == '3') {
					ans = 1;
					break;
				}

				// 델타탐색
				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];

					// 범위 내에 있고
					if (0 <= nr && nr < N && 0 <= nc && nc < N) {
						// 벽 아니고 방문안했다면
						if (map[nr][nc] != '1' && !visited[nr][nc]) {
							// 방문처리하고
							visited[nr][nc] = true;
							// 큐에 넣어라
							queue.add(new Pos(nr, nc));
						}
					}
				}
			}

			// 출력
			System.out.println("#" + tc + " " + ans);
		}
	}

}
