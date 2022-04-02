package swea;

import java.util.Scanner;

public class List1_평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] num = new int[T][10];
		int[] sum = new int[T];

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10; j++) {
				num[i][j] = sc.nextInt();
				sum[i] += num[i][j];
			}
			double[] avg = new double[T];
			avg[i] = (sum[i] / 10) + (sum[i] % 10) * 0.1;

			System.out.print("#" + (i + 1));

			System.out.println(" " + Math.round(avg[i]));

		}
	}

}
