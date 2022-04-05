package swea;

import java.util.Scanner;

public class List2_1966_숫자정렬 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int tmp = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[j + 1]) {
						tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
					}
				}
			}

			System.out.print("#" + x);
			for (int i = 0; i < N; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}
	}

}
