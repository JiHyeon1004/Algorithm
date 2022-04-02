package swea;

import java.util.Scanner;

public class List1_숫자정렬 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tmp = 0;

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] num = new int[N];

			for (int j = 0; j < N; j++) {
				num[j] = sc.nextInt();

			}
			for (int m = N - 1; m > 0; m--) {
				for (int n = 0; n < m; n++) {
					if (num[n] > num[n + 1]) {
						tmp = num[n];
						num[n] = num[n + 1];
						num[n + 1] = tmp;
					}
				}
			}
			System.out.print("#" + (i + 1));
			for (int j = 0; j < N; j++) {
				System.out.print(" " + num[j]);
			}
			System.out.println();
		}

	}

}
