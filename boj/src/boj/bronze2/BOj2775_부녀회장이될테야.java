package boj.bronze2;

import java.util.Scanner;

public class BOj2775_부녀회장이될테야 {
	public static void main(String[] args) {

		// 스캐너로 입력받아준다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 수

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt(); // 층
			int n = sc.nextInt(); // 호수
			// 해당하는 층과 호수를 모두 만들어주기 위해 행과 열에 1씩 더한 배열을 만들어준다.
			int[][] building = new int[k + 1][n + 1];

			// 0층 값 설정
			for (int i = 0; i < n + 1; i++) {
				building[0][i] = i;
			}

			// 거주민은 바로 밑 층의 1호부터 n호까지 더한 값
			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					for (int l = 1; l <= j; l++) {
						building[i][j] += building[i - 1][l];
					}
				}
			}
			// 출력
			System.out.println(building[k][n]);
		}
		// 스캐너 닫아준다.
		sc.close();
	}

}
