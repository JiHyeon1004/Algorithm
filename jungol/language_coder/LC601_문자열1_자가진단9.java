package language_coder;

import java.util.Scanner;

public class LC601_문자열1_자가진단9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.next();
		char[] alphabet = str.toCharArray();

		for (int i = str.length()-1; i >= 0; i--) {
			for (int j = i; j < i + str.length(); j++) {
				sb.append(alphabet[j % str.length()]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
