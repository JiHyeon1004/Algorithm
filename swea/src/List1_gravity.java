package swea;

import java.util.Scanner;

public class List1_gravity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int[] box = new int[L];
		int max = 0;

		for (int i = 0; i < L; i++) {
			box[i] = sc.nextInt();
		}
		for (int i = 0; i < L; i++) {
			int cnt = box.length - 1 - i;

			for (int j = i + 1; j < L; j++) {
				if (box[j] >= box[i]) {
					cnt--;

				}
			}
			if (max < cnt) {
				max = cnt;
			}

		}
		System.out.println(max);
	}

}
