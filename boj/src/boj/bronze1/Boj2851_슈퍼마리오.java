package boj.bronze1;

import java.util.Scanner;

public class Boj2851_슈퍼마리오 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] score = new int[10];
		int sum = 0;
		int num = 0;
		int sumtwo = 0;

		for (int i = 0; i < 10; i++) {
			score[i] = sc.nextInt();
		}

		sc.close();

		try {
			for (int i = 0; sum < 100; i++) {
				sum += score[i];
				num = i;
			}

			if (sum - 100 <= 100 - (sum - score[num])) {
				System.out.println(sum);
			} else {
				System.out.println(sum - score[num]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			for (int i = 0; i < 10; i++) {
				sumtwo += score[i];
			}
			System.out.println(sumtwo);
		}
	}

}
