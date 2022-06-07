package bronze4;

import java.util.Scanner;

public class Boj2439_별찍기2 {
	public static void main(String[] args) {

		//스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //N입력

		//N줄을 돌면서
		for (int i = 1; i <= N; i++) {
			//N-i만큼 공백 찍고
			for (int j = N; j > i; j--) {
				System.out.print(" ");
			}
			//i만큼 별 찍고
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			//줄바꿈
			System.out.println();
		}
	}
}
