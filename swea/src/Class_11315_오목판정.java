package swea;

import java.util.Scanner;

public class Class_11315_오목판정 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			String ans = "NO";

			for (int i = 0; i < N; i++) {
				String str = sc.next();

				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			outer: for (int i = 0; i < N - 4; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'o' && map[i + 1][j] == 'o' && map[i + 2][j] == 'o' && map[i + 3][j] == 'o'
							&& map[i + 4][j] == 'o') {
						ans = "YES";
						break outer;
					} else if (map[j][i] == 'o' && map[j][i + 1] == 'o' && map[j][i + 2] == 'o' && map[j][i + 3] == 'o'
							&& map[j][i + 4] == 'o') {
						ans = "YES";
						break outer;
					}
				}
			}

			outer: for (int i = 2; i < N; i++) {
				for (int j = 2; j < N; j++) {
					if (i + 2 < N && j + 2 < N) {
						if (map[i - 2][j - 2] == 'o' && map[i - 1][j - 1] == 'o' && map[i][j] == 'o'
								&& map[i + 1][j + 1] == 'o' && map[i + 2][j + 2] == 'o') {
							ans = "YES";
							break outer;
						} else if (map[i - 2][j + 2] == 'o' && map[i - 1][j + 1] == 'o' && map[i][j] == 'o'
								&& map[i + 1][j - 1] == 'o' && map[i + 2][j - 2] == 'o') {
							ans = "YES";
							break outer;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}
