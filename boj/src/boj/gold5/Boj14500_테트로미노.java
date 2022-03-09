package boj.gold5;

import java.util.Scanner;

public class Boj14500_테트로미노 {
	public static void main(String[] args) {

		// 스캐너로 입력받아준다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열
		int[][] paper = new int[N][M]; // 숫자가 써있는 종이판
		int[][] check = new int[N][M]; // 종이판과 크기가 같은 배열을 하나 더 만들어준다.

		// 종이판 수 입력받아준다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		sc.close();// 스캐너 닫아준다.
		int sum = 0; // 합
		int max = 0; // 최댓값(ans)
		int row = 0; // 임의로 뽑은 좌표의 행을 저장
		int column = 0; // 임의로 뽑은 좌표의 열을 저장

		// 8중포문... 4개의 좌표를 뽑아준다.
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < M; b++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < M; d++) {
						for (int e = 0; e < N; e++) {
							for (int f = 0; f < M; f++) {
								for (int g = 0; g < N; g++) {
									for (int h = 0; h < M; h++) {

										// 뽑은 4개의 좌표를 check배열에서 1로 만들어준다.
										// 뽑히지 않은 좌표들은 0
										check[a][b] = 1;
										check[c][d] = 1;
										check[e][f] = 1;
										check[g][h] = 1;

										// 한 좌표의 행, 열 값을 저장해준다.
										row = a;
										column = b;

										int cnt = 0;

										// while문을 3번 돌려주면서
										int cycle = 0;
										while (cycle < 3) {
											// 델타탐색하여
											int[] dr = { -1, 1, 0, 0 };
											int[] dc = { 0, 0, -1, 1 };

											for (int delta = 0; delta < 4; delta++) {
												int nr = row + dr[delta];
												int nc = column + dc[delta];
												if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
													continue; // 배열 인덱스에서 벗어나면 continue
												}
												// 1을 만난다면
												// 즉, 뽑아놓은 좌표가 상,하,좌,우 중에 있다면
												else if (check[nr][nc] == 1) {
													check[row][column] = 0; // 기존 좌표를 0으로 바꿔주고(다시 돌아오는 것 방지)
													row = nr; // 새로운 행 좌표를 지정해준다.
													column = nc; // 새로운 열 좌표를 지정해준다.
													cnt++; // 카운트 하나 올려줌
													break; // 포문 나가서 다시 와일문으로
												}
												// 인덱스 범위 안에 들지만 0이라면 continue
												else {
													continue;
												}
											}

											cycle++; // while문 한 번 돌 때마다 사이클 한 번씩 더해줌
										}
										// 만약 델타탐색에서 1을 찾는 데에 3번 성공했다면~ 4개의 좌표가 이어져있는것임.
										if (cnt == 3) {
											// 네 좌표의 합을 sum으로 지정해준다.
											sum = paper[a][b] + paper[c][d] + paper[e][f] + paper[g][h];
											max = Math.max(max, sum); // max보다 크다면 max에 새로이 저장

										}
										// check판 0으로 모두 초기화해준다.
										check[a][b] = 0;
										check[c][d] = 0;
										check[e][f] = 0;
										check[g][h] = 0;

									}
								}
							}
						}

					}
				}
			}
		}

		// ㅓ, ㅏ모양
		for (int i = 1; i < N - 1; i++) { // 세로기둥
			for (int j = 0; j < M; j++) {
				if (j == 0) { // 기둥이 배열 왼쪽에 붙어있다면
					sum = paper[i - 1][j] + paper[i][j] + paper[i + 1][j] + paper[i][j + 1]; // ㅏ모양으로
				} else if (j == M - 1) { // 기둥이 배열 오른쪽에 붙어있다면
					sum = paper[i - 1][j] + paper[i][j] + paper[i + 1][j] + paper[i][j - 1]; // ㅓ모양으로
				} else { // 기둥이 배열 중간에 있다면 ㅏ모양과 ㅓ모양중 더 큰 값을 갖는 쪽으로
					sum = paper[i - 1][j] + paper[i][j] + paper[i + 1][j] + Math.max(paper[i][j - 1], paper[i][j + 1]);
				}
				max = Math.max(max, sum); // max보다 크다면 max값으로 새로이 지정
			}
		}
		// ㅗ, ㅜ모양
		for (int i = 1; i < M - 1; i++) { // 가로기둥
			for (int j = 0; j < N; j++) {
				if (j == 0) { // 기둥이 윗쪽에 붙어있다면
					sum = paper[j][i - 1] + paper[j][i] + paper[j][i + 1] + paper[j + 1][i]; // ㅜ모양으로
				} else if (j == N - 1) { // 기둥이 아랫쪽에 붙어있다면
					sum = paper[j][i - 1] + paper[j][i] + paper[j][i + 1] + paper[j - 1][i]; // ㅗ모양으로
				} else { // 중간에 있다면 ㅗ와ㅜ 중 더 큰 값을 갖는 쪽으로
					sum = paper[j][i - 1] + paper[j][i] + paper[j][i + 1] + Math.max(paper[j - 1][i], paper[j + 1][i]);
				}
				max = Math.max(max, sum); // max보다 크다면 max값으로 새로이 지정
			}
		}
		System.out.println(max);
	}

}
