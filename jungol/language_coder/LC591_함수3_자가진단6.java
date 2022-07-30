package language_coder;

import java.util.Scanner;

public class LC591_함수3_자가진단6 {

	// 카운트
	static int cnt;

	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N입력

		// 카운트는 0
		cnt = 0;
		// 수열N출력
		System.out.println(sequence(N));
	}

	// sequence
	private static int sequence(int n) {
		// n이 1일 때는 1
		if (n == 1) {
			return 1;
		}
		// 재귀 돌린다.
		// n번째 수는 n/2 번째와 n-1 번째의 합
		return sequence(n / 2) + sequence(n - 1);
	}
}
