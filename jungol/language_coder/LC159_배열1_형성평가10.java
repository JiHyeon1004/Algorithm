package language_coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LC159_배열1_형성평가10 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// n입력받고 n크기의 점수 배열 만들어준다.
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];

		// 점수 배열 입력받는다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		// 정렬하고
		Arrays.sort(score);
		// 거꾸로 출력
		for (int i = n - 1; i >= 0; i--) {
			System.out.println(score[i]);
		}
	}
}
