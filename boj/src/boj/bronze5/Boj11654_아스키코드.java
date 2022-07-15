package bronze5;

import java.util.Scanner;

public class Boj11654_아스키코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		char aA = A.charAt(0);
		int ans = (int) aA;
		System.out.println(ans);
	}
}
