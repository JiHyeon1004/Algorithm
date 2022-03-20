package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11650_좌표정렬하기 {
	public static void main(String[] args) throws IOException {

		// 버퍼드리더로 입력 받아줌
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 좌표의 개수
		int N = Integer.parseInt(st.nextToken());
		int[][] coor = new int[N][2]; // 좌표 배열

		// 좌표 입력 받아준다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coor[i][0] = Integer.parseInt(st.nextToken());
			coor[i][1] = Integer.parseInt(st.nextToken());
		}

		// 버블정렬 이용
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (coor[j][0] > coor[j + 1][0]) { // x좌표 기준으로 오름차순 정렬
					// x좌표 교환
					int tmp = coor[j][0];
					coor[j][0] = coor[j + 1][0];
					coor[j + 1][0] = tmp;
					// y좌표 교환
					int temp = coor[j][1];
					coor[j][1] = coor[j + 1][1];
					coor[j + 1][1] = temp;
				}
				// 정렬 후 x좌표가 같다면
				if (coor[j][0] == coor[j + 1][0]) {
					// y좌표 기준으로 오름차순 정렬
					if (coor[j][1] > coor[j + 1][1]) {
						// x좌표 교환
						int tmp = coor[j][0];
						coor[j][0] = coor[j + 1][0];
						coor[j + 1][0] = tmp;
						// y좌표 교환
						int temp = coor[j][1];
						coor[j][1] = coor[j + 1][1];
						coor[j + 1][1] = temp;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		// 출력
		for (int i = 0; i < N; i++) {
			sb.append(coor[i][0]).append(" ").append(coor[i][1]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
