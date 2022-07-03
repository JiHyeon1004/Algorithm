package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11725_트리의부모찾기_인접행렬DFS {
	// 인접행렬로 풀면 메모리초과

	static int[][] relation; // 관계 나타낼 인접행렬
	static boolean[] visited; // 방문처리
	static int N; // 노드 수
	static int[] ans; // 답 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		relation = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		ans = new int[N + 1];

		// 관계 배열 입력받는다.
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relation[A][B] = 1;
			relation[B][A] = 1;
		}

		// dfs돌림
		dfs(1);

		// 2부터 출력
		for (int i = 2; i < N + 1; i++) {
			System.out.println(ans[i]);
		}

	}

	// dfs
	private static void dfs(int parent) {

		visited[parent] = true; // 방문처리

		// 자손이면 조상배열에 넣고 재귀돌려
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && relation[parent][i] == 1) {
				ans[i] = parent;
				dfs(i);
			}
		}

	}
}
