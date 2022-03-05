package boj.silver5;

import java.util.Scanner;

public class Boj7568_덩치 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] weight = new int[N];
		int[] height = new int[N];
		int[] ans = new int[N];

		for (int i = 0; i < N; i++) {
			weight[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (weight[j] > weight[i] && height[j] > height[i]) {
					ans[i]++;
				}
			}
			System.out.print(ans[i] + 1 + " ");
		}

	}

}
