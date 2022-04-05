package swea;

import java.util.Scanner;

public class List2_1209_Sum {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int x = 1; x <= 10; x++) {
			int N = sc.nextInt();
			int[][] arr = new int[100][100];
			int[] rowsum = new int[100];
			int[] columnsum = new int[100];
			int[] crosssum = new int[2];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 열 끼리의 합
			int rowmax = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					rowsum[i] += arr[i][j];
				}
				if (rowsum[i] > rowmax) {
					rowmax = rowsum[i];
				}
			}

			// 행끼리의 합
			int columnmax = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					columnsum[i] += arr[j][i];
				}
				if (columnsum[i] > columnmax) {
					columnmax = columnsum[i];
				}
			}

			// 대각선 합1
			int crossmax = 0;
			for (int i = 0; i < 100; i++) {
				crosssum[0] += arr[i][i];
			}

			// 대각선 합2
			for (int i = 0; i < 100; i++) {
				crosssum[1] += arr[i][99 - i];

			}

			// 대각선 합 중에 큰 것을 crossmax에 저장
			for (int i = 0; i < 2; i++) {
				if (crosssum[i] > crossmax) {
					crossmax = crosssum[i];
				}
			}

			int[] max = { rowmax, columnmax, crossmax };
			int maxnum = 0;
			for (int i = 0; i < 3; i++) {
				if (max[i] > maxnum) {
					maxnum = max[i];
				}
			}

			System.out.println("#" + x + " " + maxnum);
		}

	}

}
