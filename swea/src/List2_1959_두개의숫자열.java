package swea;

import java.util.Arrays;
import java.util.Scanner;

public class List2_1959_두개의숫자열 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		//T만큼 돌린다.
		for (int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int bignum = 0;
			int smallnum = 0;
			int max = 0;

			//N이 더 크면 bignum에 N, 아니면 반대로
			if (N >= M) {
				bignum = N;
				smallnum = M;
			} else {
				bignum = M;
				smallnum = N;
			}

			int[] bigarr = new int[bignum];
			int[] smallarr = new int[smallnum];

			//N이 M보다 크다면 먼저 받는 것이 bigarr, 아니라면 먼저받는 것이 smallarr
			if (N == bignum) {
				for (int i = 0; i < bignum; i++) {
					bigarr[i] = sc.nextInt();
				}
				for (int i = 0; i < smallnum; i++) {
					smallarr[i] = sc.nextInt();
				}
			} else {
				for (int i = 0; i < smallnum; i++) {
					smallarr[i] = sc.nextInt();
				}
				for (int i = 0; i < bignum; i++) {
					bigarr[i] = sc.nextInt();
				}

			}

			//한 칸씩 옮겨가며 곱하고 더해준다.
			//max와 sum을 비교하여 더 큰 것을 max로
			for (int i = 0; i <= bignum - smallnum; i++) {
				int sum = 0;

				for (int j = 0; j < smallnum; j++) {

					sum += (smallarr[j] * bigarr[i + j]);
				}

				if (sum > max) {
					max = sum;
				}
			}

			System.out.printf("#%d %d\n", x, max);

		}

	}

}
