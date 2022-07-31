package language_coder;

import java.util.Scanner;

public class LC527_디버깅_자가진단2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int first = A/B;
		double second = (double)A/B;
		
		System.out.printf("%d %.2f", first, second);
	}
}
