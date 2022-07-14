package silver3;

import java.util.Scanner;

public class Boj15650_N과M2 {
	static int[] arr;
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];

		comb(1, 0);
		System.out.println(sb);
	}

	private static void comb(int at, int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			comb(i + 1, depth + 1);
		}

	}
}
