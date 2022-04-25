package swea;

import java.util.Scanner;

public class String_13707_기지국 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트케이스만큼 돌리기
		for (int x = 1; x <= T; x++) {
			int n = sc.nextInt();
			char[][] map = new char[n][n];
			int cnt = 0; // H의 수를 세기 위한 카운트

			// map 배열을 입력받는다.
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}

			}

			// 전체를 탐색하며
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// A기지국이 있는 경우
					if (map[i][j] == 'A') {

						// 상하좌우 한 칸 씩을 X로 만들어버린다.
						for (int d = -1; d <= 1; d++) {
							if ((i + d) < 0 || (i + d) >= n || (j + d) < 0 || (j + d) >= n) {
								continue;
							}
							map[i + d][j] = 'X';
							map[i][j + d] = 'X';
						}
					}
					// B기지국이 있는 경우
					else if (map[i][j] == 'B') {

						// 상하좌우 두 칸 씩을 X로 만들어버린다.
						for (int d = -2; d <= 2; d++) {
							if ((i + d) < 0 || (i + d) >= n || (j + d) < 0 || (j + d) >= n) {
								continue;
							}
							map[i + d][j] = 'X';
							map[i][j + d] = 'X';
						}
					}
					// C기지국이 있는 경우
					else if (map[i][j] == 'C') {

						// 상하좌우 세 칸 씩을 X로 만들어버린다.
						for (int d = -3; d <= 3; d++) {
							if ((i + d) < 0 || (i + d) >= n || (j + d) < 0 || (j + d) >= n) {
								continue;
							}

							map[i + d][j] = 'X';
							map[i][j + d] = 'X';
						}

					}
				}

			}

			// 전체를 탐색하면서 H의 수를 세어준다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 'H') {
						cnt++;
					}
				}

			}
			System.out.printf("#%d %d\n", x, cnt);
		}
	}

}
