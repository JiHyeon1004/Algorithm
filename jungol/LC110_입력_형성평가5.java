package language_coder;

import java.util.Scanner;

public class LC110_입력_형성평가5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("yard?");
		double yard = sc.nextDouble();

		System.out.printf(" %.1fyard = %.1fcm", yard, yard * 91.44);

	}
}
