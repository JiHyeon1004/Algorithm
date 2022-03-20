package boj.bronze2;

import java.util.Scanner;

public class Boj11720_숫자의합 {
	public static void main(String[] args) {

		// 스캐너로 입력받아준다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자의 개수
		int sum = 0; // 숫자의 합
		int[] arr = new int[N]; // 숫자 배열

		// 숫자 한 번에 입력 받아주고
		String num = sc.next();

		for (int i = 0; i < N; i++) {
			arr[i] = num.charAt(i) - '0'; // int로 배열에 저장하기 위해
			sum += arr[i]; // 더해준다.
		}

		// 출력
		System.out.println(sum);
	}

}
