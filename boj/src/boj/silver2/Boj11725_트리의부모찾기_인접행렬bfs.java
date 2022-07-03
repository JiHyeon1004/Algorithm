package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11725_트리의부모찾기_인접행렬bfs {
	// 인접행렬로 풀면 메모리초과

	static int[][] relation; // 관계를 나타낼 인접행렬
	static boolean[] visited; // 방문처리
	static int N; // 노드 수
	static int[] ans; // 답 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 노드 수
		relation = new int[N + 1][N + 1]; // 인접행렬
		visited = new boolean[N + 1]; // 방문처리
		ans = new int[N + 1]; // 답 배열

		// 관계 입력받음
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relation[A][B] = 1;
			relation[B][A] = 1;
		}

		// bfs돌림
		bfs(1);

		// 2부터 출력
		for (int i = 2; i < N + 1; i++) {
			System.out.println(ans[i]);
		}

	}

	// bfs
	private static void bfs(int parent) {
		// 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		// 방문처리 후 큐에 추가
		visited[parent] = true;
		queue.add(parent);

		// 큐가 빌 때까지 돌린다.
		while (!queue.isEmpty()) {
			int x = queue.poll(); // 하나 꺼내서

			// 연결된 애들 모두 큐에 넣고, 방문처리하고, 조상배열에 추가
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && relation[i][x] == 1) {
					queue.add(i);
					visited[i] = true;
					ans[i] = x;
				}
			}
		}
	}

}
