package language_coder;

import java.util.Scanner;

public class LC517_입력_자가진단9 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// 돌면서 바로바로 출력
		for (int i = 0; i < 3; i++) {
			double N = sc.nextDouble();
			System.out.printf("%.3f\n", N);
		}
	}
}
