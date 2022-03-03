package boj.bronze1;

import java.util.Scanner;

public class Boj2562_최댓값 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = arr[0];
		int index = 0;

		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			arr[i] = num;

			if (arr[i] > max) {
				max = arr[i];
				index = i + 1;
			}

		}
		
		sc.close();
		System.out.println(max);
		System.out.println(index);

	}

}
