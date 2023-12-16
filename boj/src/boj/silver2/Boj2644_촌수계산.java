package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2644_촌수계산 {

	static int n; // 사람 수
	static int[][] people; // 사람배열
	static boolean[] checked; // 방문처리
	static int ans; // 답

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 사람 수 입력받아서 해당하는 크기의 배열을 만든다
		n = Integer.parseInt(br.readLine());
		people = new int[n + 1][n + 1];
		checked = new boolean[n + 1];

		// 관계 파악해야하는 두 명의 정보를 입력받는다.
		st = new StringTokenizer(br.readLine());
		int personA = Integer.parseInt(st.nextToken());
		int personB = Integer.parseInt(st.nextToken());

		// 간선의 수
		int nodeNum = Integer.parseInt(br.readLine());

		// 간선의 크기만큼 돌리면서 관계 입력받는다.
		for (int i = 0; i < nodeNum; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			people[parent][child] = 1;
			people[child][parent] = 1;
		}

		// bfs돌림
		bfs(personA, personB);
		// 출력
		System.out.println(ans);
	}

	// bfs
	private static void bfs(int personA, int personB) {

		// 큐 생성 후 personA 추가, 방문처리
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(personA);
		checked[personA] = true;

		ans = -1;
		// 촌수
		int cnt = -1;
		// 큐가 빌 때까지 돌린다.
		while (!queue.isEmpty()) {

			int range = queue.size(); // 동일한 거리의 사람 수
			cnt++;

			for (int i = 0; i < range; i++) {
				int person = queue.poll(); // 큐에서 하나 꺼내서
				// 만약 우리가 찾아야하는 사람이라면
				// ans를 cnt로 바꾸고 깬다.
				if (person == personB) {
					ans = cnt;
					return;
				}

				// 배열돌면서
				for (int j = 1; j < n + 1; j++) {
					// 관계가 있고 방문 안 한 사람이 있으면
					if (people[person][j] == 1 && !checked[j]) {
						checked[j] = true; // 방문처리하고
						queue.add(j); // 큐에 넣는다
					}
				}
			}
		}
	}
}
