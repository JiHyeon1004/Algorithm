package language_coder;

import java.util.Scanner;

public class LC124_선택제어문_형성평가5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();

		switch (M) {
		case 2:
			System.out.println("28");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30");
			break;

		default:
			System.out.println("31");
			break;
		}
	}
}
