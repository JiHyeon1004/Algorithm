package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4963_섬의개수 {

	// 델타탐색
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	// 지도
	static int[][] map;
	static boolean[][] visited;

	static int h; // 맵의 높이
	static int w; // 맵의 너비

	public static void main(String[] args) throws IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 0,0이 입력될때까지 돌린다.
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비 입력
			h = Integer.parseInt(st.nextToken()); // 높이 입력
			// 0,0 들어오면 깨버려
			if (w == 0 && h == 0) {
				break;
			}

			// 크기에 해당하는 지도와 방문배열 만든다.
			map = new int[h][w];
			visited = new boolean[h][w];

			// 지도 입력
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 섬의 수
			int cnt = 0;
			// 섬이 있고 방문을 안했다면 dfs 돈다
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						// 섬 개수 1추가
						cnt++;
					}
				}
			}
			// 섬의 수 출력
			System.out.println(cnt);
		}
	}

	// dfs
	private static void dfs(int r, int c) {

		// 방문처리
		visited[r][c] = true;

		// 델타탐색
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 범위 내에 있고
			if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
				// 섬이고 방문안했다면
				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					dfs(nr, nc); // dfs돌려
				}
			}
		}
	}
}
