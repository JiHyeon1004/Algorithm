package bronze5;

import java.util.Scanner;

public class Boj2475_검증수 {
	public static void main(String[] args) {
		// 검증수는 5개 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// 5개의 숫자배열
		int[] num = new int[5];
		int sum = 0; // 제곱의 합

		for (int i = 0; i < 5; i++) {
			num[i] = sc.nextInt(); // 배열을 채우면서
			num[i] = num[i] * num[i]; // 제곱해버리고
			sum += num[i]; // 합에 담아준다.
		}

		// 합을 10으로 나눈 나머지
		int ans = sum % 10;

		// 출력
		System.out.println(ans);
	}
}
