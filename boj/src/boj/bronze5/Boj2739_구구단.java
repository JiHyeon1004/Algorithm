package bronze5;

import java.util.Scanner;

public class Boj2739_구구단 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 몇 단인지

		// 구구단 계산하면서 출력
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %d", N, i, N * i);
			System.out.println();
		}
	}
}
