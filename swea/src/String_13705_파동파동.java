package swea;

import java.util.Scanner;

public class String_13705_파동파동 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스

		for (int x = 1; x <= T; x++) {
			int N = sc.nextInt(); // 배열의 크기
			int[][] arr = new int[N][N]; // 크기가 N인 배열 생성
			int M = sc.nextInt(); // 파동 시작값
			int R = sc.nextInt(); // 행 + 1
			int r = R - 1; // 행
			int C = sc.nextInt(); // 열 + 1
			int c = C - 1; // 열
			int D = sc.nextInt(); // 증감
			int[] sum = new int[N]; // 합배열
			int num = 0;

			// 파동 시작자리에 시작값 넣어줌
			arr[r][c] = M;

			// 증감값이 양수일 경우
			if (D > 0) {
				
				for (int i = 1; i < N; i++) {
					for (int j = -i; j <= i; j++) {
						num = (M + i * D);
						//255넘으면 더 이상 증가하지 않는다.
						if (M + i * D > 255) {
							num = 255;
						}
						//맨 윗 줄
						if ((r - i) >= 0) {
							if ((c + j) >= 0 && (c + j) < N) {
								arr[r - i][c + j] = (num);
							}
						}
						//맨 아랫줄
						if ((r + i) < N) {
							if ((c + j) >= 0 && (c + j) < N) {
								arr[r + i][c + j] = (num);
							}
						}
					}

					for (int j = (-i + 1); j < i; j++) {

						//왼쪾
						if ((r + j) >= 0 && (r + j) < N) {
							if ((c - i) >= 0) {
								arr[r + j][c - i] = (num);
							}
						}
						//오른쪽
						if ((r + j) >= 0 && (r + j) < N) {
							if ((c + i) < N) {
								arr[r + j][c + i] = (num);
							}
						}
					}
				}
			}

			// 증감값이 음수일 경우
			else if (D < 0) {
				for (int i = 1; i < N; i++) {
					//0 보다 줄어들 수 없다.
					if (M + i * D < 0) {
						break;
					}

					for (int j = -i; j <= i; j++) {
						//맨 윗 줄
						if ((r - i) >= 0) {
							if ((c + j) >= 0 && (c + j) < N) {
								arr[r - i][c + j] = (M + i * D);
							}
						}
						//맨 아랫줄
						if ((r + i) < N) {
							if ((c + j) >= 0 && (c + j) < N) {
								arr[r + i][c + j] = (M + i * D);
							}
						}
					}
					
					for (int j = (-i + 1); j < i; j++) {

						//왼쪽
						if ((r + j) >= 0 && (r + j) < N) {
							if ((c - i) >= 0) {
								arr[r + j][c - i] = (M + i * D);
							}
						}
						//오른쪽
						if ((r + j) >= 0 && (r + j) < N) {
							if ((c + i) < N) {
								arr[r + j][c + i] = (M + i * D);
							}
						}
					}
				}
			}
			System.out.print("#" + x);

			//sum 구해서 배열에 저장 후 읽기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum[i] += arr[i][j];
				}
				System.out.print(" " + sum[i]);
			}
			System.out.println();
		}

	}
}
