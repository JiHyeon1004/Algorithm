package boj.silver4;

import java.util.Scanner;
import java.util.Stack;

public class Boj4949_균형잡힌세상 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String str = sc.nextLine();
			Stack<Character> coupling = new Stack<>();
			String ans = "yes";

			if (str.equals(".")) {
				break;
			}

			for (int j = 0; j < str.length(); j++) {
				char single = str.charAt(j);
				if (single == '(' || single == '[') {
					coupling.push(single);
				}

				else if (single == ')') {
					if (!coupling.empty() && coupling.peek() == '(') {
						coupling.pop();
					} else {
						ans = "no";
					}
				}

				else if (single == ']') {
					if (!coupling.empty() && coupling.peek() == '[') {
						coupling.pop();
					} else {
						ans = "no";
					}
				}

				else if (str.charAt(j) == '.') {
					if (!coupling.empty()) {
						ans = "no";
					}
					System.out.println(ans);

				}
			}
		}
	}
}
