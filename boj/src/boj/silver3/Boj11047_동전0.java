package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047_동전0 {
	public static void main(String[] args) throws IOException {

		// 버퍼드리더로 입력받아줌
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 코인의 종류
		int K = Integer.parseInt(st.nextToken()); // 금액
		int[] won = new int[N]; // 코인 배열
		int coin = 0; // 코인의 개수

		// 코인 배열 입력받아준다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			won[i] = Integer.parseInt(st.nextToken());
		}

		// 큰 코인부터 내려가면서
		for (int i = N - 1; i >= 0; i--) {
			int num = K / won[i]; // 코인으로 나눈 몫
			coin += num; // 코인에 더해주고
			K -= num * won[i]; // 금액에서 몫*코인을 빼준다.
		}
		System.out.println(coin);
	}
}
