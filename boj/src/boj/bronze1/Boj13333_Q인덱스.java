package boj.bronze1;

import java.util.Scanner;

public class Boj13333_Q인덱스 {
	public static void main(String[] args) {
//q-인덱스 x 이상인 친구들을 more array에 담아서 그 길이 또한 x와 같으면 x를 출력하고 싶었음.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ref = new int[n];

		for (int i = 0; i < n; i++) {
			ref[i] = sc.nextInt();
		}

		for (int x = 0; x < 10000; x++) {
			int[] more = new int[x];
			for (int i = 0; i < n; i++) {
				if (ref[i] >= x) {
					for (int j = 0; j < x; j++) {
						more[j] = ref[i];
					}
					if (x == more.length) {
						System.out.println(x);
					}
				}
			}

		}

	}

}
