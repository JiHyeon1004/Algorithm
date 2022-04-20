package swea;

import java.util.Scanner;

public class Stack_2805_농작물수확하기 {
	public static void main(String[] args) {
		// 아 뭔가 stack으로 풀 수 있을 것 같은데 못 풀겠단말이지,,

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 입력받고

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N입력받고
			int[][] farm = new int[N][N]; // N*N 배열 만들어준다.

			for (int i = 0; i < N; i++) {
				String str = sc.next(); // 문자열로 입력받아서
				String[] alpha = str.split(""); // 끊어준 배열 만들어주고
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(alpha[j]); // 정수형으로 변환해버려
				}
			}
			// 입력완료

			int i = N / 2; // 중간인덱스
			int sum = 0;

			// 왼쪽에 있는 애들은 이렇게 해버려~
			for (int j = 0; j < N / 2; j++) {
				for (int k = -j; k < j + 1; k++) {
					sum += farm[i + k][j];
				}
			}
			// 오른쪽에 있는 애들은 이렇게 해버려~
			for (int j = N / 2; j < N; j++) {
				for (int k = -(N - j - 1); k < N - j; k++) {
					sum += farm[i + k][j];
				}
			}

			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
