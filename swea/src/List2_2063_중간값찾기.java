package swea;

import java.util.Scanner;

public class List2_2063_중간값찾기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] score = new int[N];
		int tmp = 0;

		// N만큼 입력을 받아준다.
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}

		// 버블소트로 오름차순 정렬
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (score[j] > score[j + 1]) {
					tmp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = tmp;
				}
			}
		}

		//중간에 있는 값 출력
		System.out.println(score[N / 2]);
	}

}
