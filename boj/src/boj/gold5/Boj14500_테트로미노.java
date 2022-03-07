package boj.gold5;

import java.util.Scanner;

public class Boj14500_테트로미노 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] paper = new int[N][M];
		int[][] check = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		int sum = 0;
		int foursum = 0;
		int max = 0;
		int cnt = 0;
		int row = 0;
		int column = 0;

		for (int a = 0; a < N; a++) {
			for (int b = 0; b < M; b++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < M; d++) {
						for (int e = 0; e < N; e++) {
							for (int f = 0; f < M; f++) {
								for (int g = 0; g < N; g++) {
									for (int h = 0; h < M; h++) {
										if (10 * a + b != 10 * c + d && 10 * a + b != 10 * e + f
												&& 10 * a + b != 10 * g + h && 10 * c + d != 10 * e + f
												&& 10 * c + d != 10 * g + h && 10 * e + f != 10 * g + h) {
											sum = paper[a][b] + paper[c][d] + paper[e][f] + paper[g][h];
											check[a][b] = 1;
											check[c][d] = 1;
											check[e][f] = 1;
											check[g][h] = 1;

											row = a;
											column = b;

											while (cnt < 5) {
												int[] dr = { -1, 1, 0, 0 };
												int[] dc = { 0, 0, -1, 1 };

												for (int delta = 0; delta < 4; delta++) {
													int nr = row + dr[delta];
													int nc = column + dc[delta];
													if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
														continue;
													} else if (check[nr][nc] == 1) {
														row = nr;
														column = nc;
														cnt++;
														break;
													} else {
														continue;
													}
												}

											}
											if (cnt == 4) {
												foursum = sum;
												if (foursum > max) {
													max = foursum;
												}

											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println(max);
	}

}
