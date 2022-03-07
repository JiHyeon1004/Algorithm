package boj.silver3;

import java.util.Scanner;

public class Boj1003_피보나치함수 {

	public static int zeroCnt;
	public static int oneCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			zeroCnt = 0;
			oneCnt = 0;
			fibonacci(N);

			System.out.println(zeroCnt + " " + oneCnt);
		}

	}

	public static int fibonacci(int n) {
		if (n == 0) {
			zeroCnt++;
			return 0;
		} else if (n == 1) {
			oneCnt++;
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}