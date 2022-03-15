package boj.silver3;

import java.util.Scanner;
import java.util.Stack;

public class Boj1874_스택수열 {
	public static void main(String[] args) {

		Stack<Integer> seq = new Stack<>();

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int stacknum = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			if (num > stacknum) {
				for (int j = stacknum + 1; j <= num; j++) {
					seq.push(i);
					sb.append("+").append("\n");
					stacknum++;
				}

			} else if (seq.peek() >= num) {
				for (int j = seq.peek(); j > num; j--) {
					if (!seq.empty()) {
						seq.pop();
						sb.append("-").append("\n");
					}
				}
			}
			seq.pop();
			sb.append("-").append("\n");
		}

		System.out.println(sb.toString());

	}

}
