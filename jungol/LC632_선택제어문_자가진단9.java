package language_coder;

import java.util.Scanner;

public class LC632_선택제어문_자가진단9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println(Math.min(A, Math.min(B, C)));
	}
}
