package silver5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj11651_좌표정렬하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] coordinate = new int[N][2];

		for (int i = 0; i < N; i++) {
			coordinate[i][0] = sc.nextInt();
			coordinate[i][1] = sc.nextInt();
		}

		Arrays.sort(coordinate, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}

		});

		for (int i = 0; i < N; i++) {
				System.out.println(coordinate[i][0] + " " + coordinate[i][1]);
		}
	}
}
