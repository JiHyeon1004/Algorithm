package swea;

import java.util.Scanner;

public class String_1213_String {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int x = 1; x <= 10; x++) {
			int N = sc.nextInt();
			String str = sc.next();
			String text = sc.next();
			int S = str.length();
			int T = text.length();
			int cnt = 0;

			for (int i = 0; i < T - S + 1; i++) {
				boolean is = true;
				for (int j = 0; j < S; j++) {
					if (str.charAt(j) != text.charAt(j + i)) {
						is = false;
						break;
					}
				}
				if (is == true) {
					cnt++;
				}
			}
			System.out.println("#" + x + " " + cnt);
		}
	}

}
