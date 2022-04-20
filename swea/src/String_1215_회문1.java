package swea;

import java.util.Scanner;

public class String_1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int x = 1; x <= 10; x++) {
			int N = sc.nextInt();
			char[][] arr = new char[8][8];
			int cnt = 0;

			// char arr 입력 받음.
			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for(int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			// 가로로 탐색
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) {
					boolean flag = true;
					for (int k = 0; k < (N / 2); k++) {
						if (arr[i][j + k] != arr[i][j + N - 1 - k]) {
							flag = false;
							break;
						}

					}
					if (flag) {
						cnt++;
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) {
					boolean flag = true;
					for (int k = 0; k < (N / 2); k++) {
						if (arr[j + k][i] != arr[j + N - 1 - k][i]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						cnt++;
					}
				}
			}
			System.out.println("#" + x + " " + cnt);
		}
	}

}
