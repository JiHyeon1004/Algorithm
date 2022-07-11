package silver3;

import java.util.Scanner;

public class Boj15649_N과M1 {

	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		// N개의 숫자가 있고
		int N = sc.nextInt();
		// M개를 뽑을거야
		int M = sc.nextInt();

		// 순열배열
		arr = new int[M];
		visit = new boolean[N + 1]; // 방문처리
		// 순열돌린다.
		perm(N, M, 0);
		// 출력
		System.out.println(sb);
	}

	private static void perm(int n, int m, int depth) {
		if (depth == m) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				perm(n, m, depth + 1);
				visit[i] = false;
			}
		}
	}
}
