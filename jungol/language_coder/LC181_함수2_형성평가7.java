package language_coder;

import java.util.Scanner;

public class LC181_함수2_형성평가7 {
	public static void main(String[] args) {
		System.out.print("radius : ");
		Scanner sc = new Scanner(System.in);

		// 반지름 입력
		double r = sc.nextDouble();

		// 면적 구해서
		double area = r * r * 3.141592;

		// 소수점 넷째자리에서 반올림
		double ans = Math.round(area * 1000) / 1000.0;

		// 출력
		System.out.println("area = " + ans);
	}
}
