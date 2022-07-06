package silver3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2606_바이러스 {

	static int N; // 컴퓨터의 수
	static int[][] computer; // 컴퓨터 배열
	static boolean[] visited; // 방문처리
	static int cnt; // 감염된 검퓨터의 수

	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 컴퓨터의 수
		int L = sc.nextInt(); // 간선 수
		computer = new int[N + 1][N + 1]; // 컴퓨터 연결 정보
		visited = new boolean[N + 1]; // 방문처리

		// 연결된 컴퓨터들에 1로 표시한다.
		for (int i = 0; i < L; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			computer[a][b] = 1;
			computer[b][a] = 1;
		}

		// 1번 컴퓨터가 감염되었으므로 1번으로 bfs를 돌린다.
		bfs(1);

		// 감염된 컴퓨터의 수를 출력한다.
		System.out.println(cnt);

	}

	// bfs
	private static void bfs(int a) {
		// 큐 생성
		Queue<Integer> queue = new LinkedList<>();

		// 방문처리하고
		visited[a] = true;
		queue.add(a); // 큐에 넣는다.
		cnt = 0; // 감염된 컴퓨터의 수

		// 큐가 빌 때까지 돌린다.
		while (!queue.isEmpty()) {
			int x = queue.poll(); // 큐에서 꺼내서

			// 연결된 컴퓨터 검색
			for (int i = 1; i < N + 1; i++) {
				// 연결되어있고 방문처리가 되어있지않다면
				if (computer[x][i] == 1 && !visited[i]) {
					queue.add(i); // 큐에 추가하고
					visited[i] = true; // 방문처리
					cnt++; // 감염된 컴퓨터 수 1 추가
				}
			}
		}
	}

}
