package boj.bronze2;

import java.util.Scanner;

public class Boj2292_벌집 {

	public static void main(String[] args) {

		//스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //몇 번 방인지
		int ans = 1; //기본 1부터 시작

		
		if (N > 1) {
			int i = 1;
			N = N-1;
			while (true) {
				int nextN = N - (6 * i);
				if (nextN <= 0) {
					ans = i + 1;
					break;
				}
				i++;
				N = nextN;
			}
		}

		System.out.println(ans);
	}

}
