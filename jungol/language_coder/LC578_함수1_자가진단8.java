package language_coder;

import java.util.Scanner;

public class LC578_함수1_자가진단8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		for(int i = Math.min(A, B); i <= Math.max(A, B); i++) {
			System.out.println("== " + i + "dan ==");
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %2d", i, j, i*j);
				System.out.println();
			}
			System.out.println();
		}
	}
}
