package swea;

import java.util.Scanner;

public class Class_1961_숫자배열회전 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 수

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열 크기
			int[][] num = new int[N][N]; // 배열 만들어주고
			String[][] span = new String[N][3]; // 회전된 배열

			// 원래 배열 입력받아준다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					num[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {

				// 90도 회전
				String lList = "";
				for (int k = 0; k < N; k++) {
					lList += (num[N - 1 - k][i]);
					span[i][0] = lList;
				}

				// 180도 회전
				String mList = "";
				for (int k = 0; k < N; k++) {
					mList += (num[N - 1 - i][N - 1 - k]);
					span[i][1] = mList;
				}

				// 270도 회전
				String rList = "";
				for (int k = 0; k < N; k++) {
					rList += (num[k][N - 1 - i]);
					span[i][2] = rList;
				}

			}

			// 출력
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(span[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
