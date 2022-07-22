package bronze5;

import java.util.Scanner;

public class Boj10950_AplusB3 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 수
		int T = sc.nextInt();

		// 테스트케이스만큼 돌린다
		for (int i = 0; i < T; i++) {
			// 입력받아서 더한 후 출력
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(A + B);
		}
	}
}
