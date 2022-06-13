package language_coder;

import java.util.Scanner;

public class LC525_연산자_자가진단8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		// A가 제일 크면 1, 아니면 0출력
		if ((A > B && A > C)) {
			System.out.print(1 + " ");
		} else {
			System.out.println(0 + " ");
		}

		// 세 수가 모두 같으면 1, 아니면 0출력
		if (A == B && A == C) {
			System.out.println(1 + " ");
		} else {
			System.out.println(0 + " ");
		}

	}
}
