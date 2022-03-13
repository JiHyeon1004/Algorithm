package boj.silver4;

import java.util.Scanner;

public class Boj10773_제로 {
	public static void main(String[] args) {

		// 스캐너로 입력
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 입력받을 수들의 개수
		int[] num = new int[K]; // K짜리 배열

		// 숫자를 입력받아주면서
		for (int i = 0; i < K; i++) {
			num[i] = sc.nextInt();
			if (num[i] == 0) { // 입력받은 수가 0이라면
				for (int j = i - 1; j >= 0; j--) { // 이전 숫자로 돌아가면서
					if (num[j] != 0) { // 이전 숫자가 0이 아니라면
						num[j] = 0; // 0으로 바꿔주고
						break; // 멈춰!
					}
				}
			}
		}
		sc.close();
		int sum = 0;

		// 합계 구해주고
		for (int i = 0; i < K; i++) {
			sum += num[i];
		}

		// 출력
		System.out.println(sum);
	}

}
