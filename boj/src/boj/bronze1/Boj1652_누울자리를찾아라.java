package boj.bronze1;

import java.util.Scanner;

public class Boj1652_누울자리를찾아라 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] room = new char[N][N];
		int[][] bed = new int[N][N];
		int rowcnt = 0;
		int colcnt = 0;

		// 입력
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				room[i][j] = str.charAt(j);
			}
		}

		// 가로로 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[i][j] == '.') {
					bed[i][j] = 1;
				}
			}
			for (int j = 1; j < N; j++) {
				if (bed[i][j - 1] != 0 && bed[i][j] != 0) {
					bed[i][j] = (bed[i][j - 1] + 1);
				}
			}
		}
		// 2있으면 rowcnt ++
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (bed[i][j] == 2) {
					rowcnt++;
				}
			}
		}

		// 세로로 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[j][i] == '.') {
					bed[j][i] = 1;
				}
			}
			for (int j = 1; j < N; j++) {
				if (bed[j - 1][i] != 0 && bed[j][i] != 0) {
					bed[j][i] = (bed[j - 1][i] + 1);
				}
			}
		}
		
		// 2있으면 colcnt ++
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (bed[i][j] == 2) {
					colcnt++;
				}
			}
		}

		System.out.println(rowcnt);
		System.out.println(colcnt);
	}

}
