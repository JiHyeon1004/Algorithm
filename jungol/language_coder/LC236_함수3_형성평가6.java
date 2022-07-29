package language_coder;

import java.util.Scanner;

public class LC236_함수3_형성평가6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int multiple = A * B * C;
		String mtpl = String.valueOf(multiple);
		char[] num = mtpl.toCharArray();
		int ans = 1;

		for (int i = 0; i < num.length; i++) {
			if (num[i] != '0') {
				ans *= num[i] - '0';
			}
		}
		System.out.println(ans);
	}
}
