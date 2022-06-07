package bronze2;

import java.util.Scanner;

public class Boj2577_숫자의개수 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// 세 수 입력받아서
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		// 곱해준 값을 문자배열로
		String str = String.valueOf(A * B * C);
		char[] multiple = str.toCharArray();

		// 숫자배열
		int[] num = new int[10];

		// 문자배열에 해당하는 숫자배열값을 하나씩 증가시켜준다.
		for (int i = 0; i < multiple.length; i++) {
			num[multiple[i] - '0']++;
		}
		// 출력
		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}
	}
}
