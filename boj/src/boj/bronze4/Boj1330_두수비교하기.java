package bronze4;

import java.util.Scanner;

public class Boj1330_두수비교하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A > B) {
			System.out.println(">");
		}
		else if(A < B) {
			System.out.println("<");
		}
		else {
			System.out.println("==");
		}
	}
}
