package bronze3;

import java.util.Scanner;

public class Boj2742_기찍N {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// N입력
		int N = sc.nextInt();

		// 거꾸로 찍기
		for (int i = N; i > 0; i--) {
			System.out.println(i);
		}
	}
}
