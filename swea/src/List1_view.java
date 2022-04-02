package swea;

import java.util.Scanner;

public class List1_view {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int x = 0; x < 10; x++) {

			int T = sc.nextInt();
			int[] building = new int[T];
			int[][] house = new int[T][255];
			int cnt = 0;

			for (int i = 0; i < T; i++) {
				building[i] = sc.nextInt();
			}
			for (int i = 0; i < T; i++) {
				for (int j = 0; j < building[i]; j++) {
					house[i][j] = 1;
				}
			}
			for (int i = 2; i < T - 2; i++) {
				for (int j = 0; j < 255; j++) {
					if (house[i][j] == 1 && house[i - 2][j] == 0 && house[i - 1][j] == 0 && house[i + 1][j] == 0
							&& house[i + 2][j] == 0) {
						cnt++;
					}
				}
			}
			System.out.print("#" + (x + 1));
			System.out.println(" " + cnt);
		}
	}

}
