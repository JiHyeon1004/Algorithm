package language_coder;

import java.util.Scanner;

public class LC115_연산자_형성평가5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 민수의 키, 몸무게
		int msHeight = sc.nextInt();
		int msWeight = sc.nextInt();

		// 기영이의 키, 몸무게
		int gyHeight = sc.nextInt();
		int gyWeight = sc.nextInt();

		// 둘 다 크면 1
		if (msHeight > gyHeight && msWeight > gyWeight) {
			System.out.println("1");
		}
		// 아니면 0
		else {
			System.out.println("0");
		}
	}
}
