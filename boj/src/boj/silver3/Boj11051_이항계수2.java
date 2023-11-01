package silver3;

import java.util.Scanner;

public class Boj11051_이항계수2 {
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		dp = new int[N + 1][K + 1];

		System.out.println(combination(N, K));
	}

	private static int combination(int n, int k) {
		if (dp[n][k] > 0) {
			return dp[n][k];
		}
		if (n == k || k == 0) {
			return dp[n][k] = 1;
		} else {
			return dp[n][k] = (combination(n - 1, k - 1) + combination(n - 1, k)) % 10007;
		}
	}
}
