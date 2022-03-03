package boj.bronze1;

import java.util.Scanner;

public class Boj2748_피보나치수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] seq = new long[n + 1];
		// 주석처리한 것은 사용자 입장에서 수를 셌을 때의 경우를 표현함.
//		int[] seq = new int[n]; 
		sc.close();
		seq[0] = 0;
		if (n > 0) {
			seq[1] = 1;
		}

		for (int i = 2; i <= n; i++) {
			seq[i] = (seq[i - 1] + seq[i - 2]);
		}
		System.out.println(seq[n]);
//		for (int i = 2; i < n; i++) {
//			seq[i] = (seq[i - 1] + seq[i - 2]);
//		}
//		System.out.println(seq[n-1]);
	}

}
