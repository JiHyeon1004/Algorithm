package boj.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2108_통계학 {
	public static void main(String[] args) {

		// 스캐너로 입력 받아준다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력받을 숫자들의 개수
		int[] num = new int[N]; // 배열 생성
		double sum = 0;

		// 숫자들 입력받아준다.
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
			sum += num[i]; // 산술평균을 위한 sum
		}

		// 산술평균
		double mean = sum / N;

		// 중앙값
		Arrays.sort(num); // 오름차순 정렬
		int med = num[N / 2]; // 중앙값을 med로

		// 최댓값과 최솟값
		int min = num[0];
		int max = num[N - 1];

		// 최빈값 (음수가 있을 때에도 생각해주어야한다.)
		int mode = 0;

		// 범위
		int range = max - min;

		// 출력
		System.out.println(Math.round(mean));
		System.out.println(med);
		System.out.println(mode);
		System.out.println(range);
	}
}
