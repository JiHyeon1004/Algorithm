package boj.bronze2;

import java.util.Scanner;

public class Boj2292_벌집 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 1;

		if (N > 1) {
			int i = 1;
			N = N-1;
			while (true) {
				int nextN = N - (6 * i);
				if (nextN <= 0) {
					ans = i + 1;
					break;
				}
				i++;
				N = nextN;
			}
		}

		System.out.println(ans);
	}

}
