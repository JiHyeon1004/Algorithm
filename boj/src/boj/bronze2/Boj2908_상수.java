package bronze2;

import java.util.Scanner;

public class Boj2908_상수 {
	public static void main(String[] args) {

		//스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		//두 수 A, B 입력받는다.
		int A = sc.nextInt();
		int B = sc.nextInt();

		//거꾸로
		A = A / 100 + (A % 100) / 10 * 10 + (A % 100) % 10 * 100;
		B = B / 100 + (B % 100) / 10 * 10 + (B % 100) % 10 * 100;
		
		//큰 수 출력
		System.out.println(Math.max(A, B));
	}
}
