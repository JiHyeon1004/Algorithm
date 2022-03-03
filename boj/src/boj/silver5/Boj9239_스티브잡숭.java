package boj.silver5;

import java.util.Scanner;

public class Boj9239_스티브잡숭 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// X를 입력받음.
		double X = sc.nextDouble();
		boolean flag = false;

		// 범위 내의 모든 수에 대하여...
		for (int i = 10; i < 100000000; i++) {
			// int i를 문자열 original로 만들어준다.
			String original = String.valueOf(i);
			int L = original.length(); // i의 자릿수

			char[] change = original.toCharArray(); // original을 char배열로 바꿈
			char first = change[0]; // 첫 숫자는 first
			char last = change[L - 1]; // 마지막 숫자는 last

			// i의 첫 숫자와 마지막 숫자 교환
			change[0] = last;
			change[L - 1] = first;

			// 교환된 숫자를 changed라는 문자열로 저장
			String changed = String.valueOf(change);
			int lastlast = Integer.parseInt(changed);

			// X를 곱한 수
			double multiple = (X * i); // X*i를 multiple에 저장

			// lastlast와 multiple이 같다면 i를 출력하고 true로 바꾸자
			if ((lastlast - multiple) == 0) {
				System.out.println(i);
				flag = true;
			} else {
				continue;
			}

		}
		if (flag = false) {
			System.out.println("No solution");
		}
	}

}
