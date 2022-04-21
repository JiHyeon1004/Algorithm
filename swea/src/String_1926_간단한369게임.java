package swea;

import java.util.Scanner;

public class String_1926_간단한369게임 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			int baek = i / 100; // 백의 자리
			int shib = i / 10; // 십의 자리
			int il = i % 10; // 일의 자리

			if (baek == 3 || baek == 6 || baek == 9) { // 백의 자리가 369일 때
				if (shib == 3 || shib == 6 || shib == 9) { // 십의 자리도 369일 때
					if (il == 3 || il == 6 || il == 9) { // 세 자리가 모두 369일 때
						System.out.print("--- ");

					} else {
						System.out.print("-- "); // 백의 자리와 십의 자리가 369일 때
					}
				} else if (il == 3 || il == 6 || il == 9) {
					System.out.print("-- "); // 백의 자리와 십의 자리가 369일 때
				} else {
					System.out.print("- "); // 백의 자리만 369일 때
				}

			} else if (baek != 3 && baek != 6 && baek != 9) {
				if (shib == 3 || shib == 6 || shib == 9) { // 십의 자리가 369일 때
					if (il == 3 || il == 6 || il == 9) { // 십의 자리와 일의 자리가 369일 때
						System.out.print("-- ");

					} else {
						System.out.print("- "); // 십의 자리만 369일 때
					}
				} else if (il == 3 || il == 6 || il == 9) {
					System.out.print("- "); // 일의 자리만 369일 때
				} else {
					System.out.printf("%s ", i); // 369가 없을 때
				}

			}
		}

	}
}
