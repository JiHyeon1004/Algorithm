package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2798_블랙잭 {
	public static void main(String[] args) throws IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N, M 입력받아줌
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] card = new int[N]; // 카드배열
		int M = Integer.parseInt(st.nextToken());
		int maxSum = 0; // 문제에서 요구하는 최대합

		// 카드배열 입력받는다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		// 세 장의 카드를 골라서
		outer: for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = card[i] + card[j] + card[k]; // 세 수를 더한다.
					// 더한 값이 M이면 게임 끝
					if (sum == M) {
						maxSum = M;
						break outer;
					}
					// M보다 작고 지금까지 합보다 크면 저장
					else if (sum >= maxSum && sum < M) {
						maxSum = sum;
					}
				}
			}
		}
		// 출력
		System.out.println(maxSum);
	}
}
