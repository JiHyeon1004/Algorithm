package language_coder;

import java.util.Scanner;

public class LC139_반복제어문2_형성평가10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if (A >= B) {
			for (int j = 1; j < 10; j++) {
				for (int i = A; i >= B; i--) {
					System.out.printf("%d * %d =%3d   ", i, j, i * j);
				}
				System.out.println();
			}
		} else {
			for (int j = 1; j < 10; j++) {
				for (int i = A; i <= B; i++) {
					System.out.printf("%d * %d =%3d   ", i, j, i * j);
				}
				System.out.println();
			}
		}
	}
}
