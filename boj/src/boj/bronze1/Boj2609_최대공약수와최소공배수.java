package bronze1;

import java.util.HashSet;
import java.util.Scanner;

public class Boj2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		int[] forA = new int[Math.max(A, B) + 1];
		int[] forB = new int[Math.max(A, B) + 1];

		for (int i = 1; i <= A; i++) {
			if (A % i == 0) {
				forA[i] = 1;
			}
		}
		for (int i = 1; i <= B; i++) {
			if (B % i == 0) {
				forB[i] = 1;
			}
		}

		for (int i = B; i > 0; i--) {
			if (forB[i] == 1 && forA[i] == 1) {
				System.out.println(i);
				break;
			}
		}

		for (int i = Math.max(A, B); i <= 100000000; i++) {
			if (i % A == 0 && i % B == 0) {
				System.out.println(i);
				break;
			}
		}

	}
}
