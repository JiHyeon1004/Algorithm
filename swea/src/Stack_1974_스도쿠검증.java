package swea;

import java.util.Scanner;

public class Stack_1974_스도쿠검증 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 입력받음

		// 테스트 케이스만큼 돌린다
		for (int tc = 1; tc <= T; tc++) {
			// 스도쿠 판을 만들어준다.
			int[][] sudoku = new int[9][9];
			int rowsum; // 가로합
			int colsum; // 세로합
			int sqsum; // 사각형합
			boolean isAns = true; // 트루를 초기값으로 갖고, 스도쿠가 정답이 아닐 경우 false가 찍히도록

			// 스도쿠 판 채우기
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 가로합, 세로합 구해서 합이 45와 다른 게 있으면 땡!
			outer: for (int i = 0; i < 9; i++) {
				rowsum = 0;
				colsum = 0;
				for (int j = 0; j < 9; j++) {
					rowsum += sudoku[i][j];
					colsum += sudoku[j][i];
				}
				if (rowsum != 45 || colsum != 45) {
					isAns = false;
					break outer;
				}
			}
			// 가로세로합에서 충족했을 때 사각형 합 구해서 합이 45와 다른 게 있으면 땡!!
			outertwo: if (isAns == true) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						sqsum = 0;
						for (int k = 0; k < 3; k++) {
							for (int l = 0; l < 3; l++) {
								sqsum += sudoku[3 * i + k][3 * j + l];
							}
						}
						if (sqsum != 45) {
							isAns = false;
							break outertwo;
						}
					}
				}
			}
			// 트루라면 1, 아니라면 0
			if (isAns != false) {
				System.out.printf("#%d 1\n", tc);
			} else {
				System.out.printf("#%d 0\n", tc);
			}
		}
	}

}
