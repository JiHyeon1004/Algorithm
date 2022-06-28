package language_coder;

import java.util.Scanner;

public class LC586_함수2_자가진단8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int minus = A - B;
		int plus = A + B;
		int ansA = (int) Math.pow(minus, 2);
		int ansB = (int) Math.pow(plus, 3);
		
		System.out.println("(" + A + " - " + B + ") ^ 2 = " + ansA);
		System.out.println("(" + A + " + " + B + ") ^ 3 = " + ansB);

	}
}
