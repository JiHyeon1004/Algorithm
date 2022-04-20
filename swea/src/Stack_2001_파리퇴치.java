package swea;

import java.util.Scanner;

public class Stack_2001_파리퇴치 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 입력받음

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N입력받고
			int[][] fly = new int[N][N]; // N*N크기의 배열 생성
			int M = sc.nextInt(); // M입력받음
			int max = 0; // max의 초기값은 0

			// 파리숫자 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}

			// M*M 영역의 합을 전체탐색한다.
			for (int i = 0; i < (N - M + 1); i++) {
				for (int j = 0; j < (N - M + 1); j++) {
					int sum = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							sum += fly[i + k][j + l];

						}
					}
					// 합이 max보다 크면 max에 저장
					if (sum > max) {
						max = sum;
					}
				}
			}

			// 출력해버려
			System.out.printf("#%d %d\n", tc, max);
		}
	}

}
