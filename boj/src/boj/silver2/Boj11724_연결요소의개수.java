package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11724_연결요소의개수 {

	static int[][] num; // 연결배열
	static boolean[] visited; // 방문배열
	static int N; // 숫자 개수

	public static void main(String[] args) throws IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 숫자의 개수 입력받아서 해당하는 크기의 숫자, 방문배열 생성
		N = Integer.parseInt(st.nextToken());
		num = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		// 간선의 개수
		int M = Integer.parseInt(st.nextToken());

		// 연결관계 입력받는다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			num[a][b] = 1;
			num[b][a] = 1;
		}
		// 연결요소의 개수
		int cnt = 0;
		// 돌면서 연결관계를 갖고 방문이력이 없는 애들은 dfs돌리고 연결요소개수 1 증가
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		// 출력
		System.out.println(cnt);
	}

	// dfs
	private static void dfs(int r) {
		// 방문처리
		visited[r] = true;

		// 또 돌려
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && num[r][i] == 1) {
				dfs(i);
			}
		}

	}
}
