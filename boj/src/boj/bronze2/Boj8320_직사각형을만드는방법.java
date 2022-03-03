package boj.bronze2;

import java.util.Scanner;

public class Boj8320_직사각형을만드는방법 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;

		for (int i = 1; i < 5000; i++) {
			for (int j = 1; j <= n / i; j++) {
				cnt++;
			}
		}
		int i = 1;
		while (n / i >= 1) {
			cnt--;
			i++;
		}
		System.out.println(cnt);
	}

}
