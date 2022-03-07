package boj.silver5;

import java.util.Scanner;

public class Boj1436_영화감독숌 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int cnt = 0;

		int i = 666;
		while (cnt < N) {
			String str = String.valueOf(i);
			if (str.contains("666")) {
				cnt++;
				if (cnt == N) {
					break;
				}
			}
			i++;
		}
		System.out.println(i);
	}
}
