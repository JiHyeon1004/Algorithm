package swea;

import java.util.Scanner;

public class List2_1204_최빈수구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트케이스만큼 돌린다.
		for (int x = 1; x <= T; x++) {
			int[] score = new int[1000]; // 10000칸짜리 배열 생성
			int max = 0;
			int maxidx = 0;
			int N = sc.nextInt();

			// 1000개의 숫자를 입력받고, 입력받은 번호의 배열 1씩 증가
			for (int j = 0; j < 1000; j++) {
				int s = sc.nextInt();
				score[s] += 1;
			}

			// 점수의 개수가 max보다 크면 max를 score[j]로 교환
			for (int j = 0; j < 1000; j++) {
				if (score[j] > max) {
					max = score[j];
					maxidx = j;
				}

				// 점수가 같을 때는 큰 인덱스 값으로
				if (score[j] >= max && j > maxidx) {
					max = score[j];
					maxidx = j;
				}

			}

			System.out.print("#" + x);
			System.out.println(" " + maxidx);

		}

	}

}
