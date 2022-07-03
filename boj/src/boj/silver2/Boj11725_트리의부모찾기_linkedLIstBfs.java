package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11725_트리의부모찾기_linkedLIstBfs {

	static ArrayList<Integer>[] relation; // 관계를 나타낼 어레이리스트 배열
	static boolean[] visited; // 방문처리
	static int N; // 노드 수
	static int[] ans; // 답 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 노드 수
		relation = new ArrayList[N + 1]; // 관계를 나타낼 인접리스트
		visited = new boolean[N + 1]; // 방문처리
		ans = new int[N + 1]; // 답 배열

		// 리스트 생성
		for (int i = 0; i < relation.length; i++) {
			relation[i] = new ArrayList<Integer>();
		}

		// 리스트 채워줌
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relation[A].add(B);
			relation[B].add(A);
		}

		// bfs돌려
		bfs(1);

		// 2부터 출력
		for (int i = 2; i < N + 1; i++) {
			System.out.println(ans[i]);
		}

	}

	// bfs
	private static void bfs(int parent) {
		// 큐 만들어준다.
		Queue<Integer> queue = new LinkedList<>();

		// 부모를 방문처리하고 큐에 넣어줌
		visited[parent] = true;
		queue.add(parent);

		// 큐가 빌 때까지
		while (!queue.isEmpty()) {
			int x = queue.poll(); // 하나 꺼내서

			// relation에 들어있는 애들 돌리면서
			for (Integer i : relation[x]) {
				// 방문안했으면 큐에 넣고 방문처리하고 조상배열에 넣어
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
					ans[i] = x;
				}
			}
		}
	}

}
