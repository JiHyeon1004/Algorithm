package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1546_평균 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N을 크기로 하는 배열을 만들어서 점수를 담는다.
		// max값을 구한다.
		// 평균을 구해서 max로 나누고 100을 곱한다.

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 과목 개수
		int[] score = new int[N]; // 점수 배열
		int max = 0; // 점수의 최댓값
		int sum = 0; // 점수의 합 (평균 구할 때 사용)

		st = new StringTokenizer(br.readLine());
		/*
		 * 점수 입력 받아주면서 최댓값인지 확인하고 sum에 더해준다.
		 */
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if (max < score[i]) {
				max = score[i];
			}
			sum += score[i];
		}

		// 이전 점수의 평균
		double avg = sum / (double) N;

		// 고친 점수의 평균
		double newAvg = avg / max * 100;

		System.out.println(newAvg);

	}
}
