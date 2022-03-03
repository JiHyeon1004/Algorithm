package boj.bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class Boj4344_평균은넘겠지 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// test case만큼 돌리기
		for (int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			int[] score = new int[N];
			int sum = 0;
			int cnt = 0;
			double avg = 0;
			double ans = 0;

			// score 배열 입력받음
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				sum += score[i];// sum에 차곡차곡 더해준다.
			}

			// avg 구해줌
			avg = sum / N;

			// 배열을 돌면서 평균보다 크면 카운트세기
			for (int i = 0; i < N; i++) {
				if (score[i] > avg) {
					cnt++;
				}
			}

			// 카운트를 더블로 형변환하여 학생 수로 나누어주고 곱하기 100(퍼센트니깐)
			ans = ((double) cnt / N) * 100;

			// 소숫점 셋째자리까지 출력
			System.out.printf("%.3f%%", ans); //%%써주면 %가 붙는다.
			System.out.println();
//			System.out.println("%");
		}

	}

}
