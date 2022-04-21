package swea;

import java.util.Scanner;

public class String_1954_달팽이숫자 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		//테스트케이스만큼 돌린다.
		for (int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			//받은 N의 크기대로 snail배열 생성
			int[][] snail = new int[N][N];
			int num = 1;

			//맨 윗 줄 왼쪽에서 오른쪽으로 값 입력
			for (int i = 0; i < N; i++) {
				snail[0][i] = num++;
			}

			//num이 N의 제곱이 되면 끝낸다.
			while (num <= N * N) {
				for (int i = 0; i < N / 2; i++) {
					//오른쪽 위에서 아래로
					for (int j = (1 + i); j < (N - i); j++) {
						snail[j][N - 1 - i] = num++;
					}
					//아래 오른쪽에서 왼쪽으로
					for (int j = (1 + i); j < (N - i); j++) {
						snail[N - 1 - i][N - j - 1] = num++;
					}
					//왼쪽 아래에서 위로
					for (int j = (1 + i); j < (N - 1 - i); j++) {
						snail[N - 1 - j][i] = num++;
					}
					//위 왼쪽에서 오른쪽으로
					for (int j = (2 + i); j < (N - i); j++) {
						snail[i + 1][j - 1] = num++;
					}
				}
			}

			System.out.println("#" + x);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}
