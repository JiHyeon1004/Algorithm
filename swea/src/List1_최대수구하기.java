package swea;

import java.util.Scanner;

public class List1_최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] num = new int[T][10];
		int[] max = new int[T];

		for (int j = 0; j < T; j++) {
			for (int i = 0; i < 10; i++) {
				num[j][i] = sc.nextInt();
				if (num[j][i] > max[j]) {
					max[j] = num[j][i];
				}
			}

		}

		for (int i = 0; i < T; i++) {
			System.out.println("#" + (i + 1) + " " + max[i]);
		}
	}

}
