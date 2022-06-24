package bronze2;

import java.util.Scanner;

public class Boj16561_3의배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int sum = 1;
		int cnt = 2;

		for (int i = 9; i < N; i += 3) {
			sum += cnt;
			cnt += 1;
		}
		System.out.println(sum);
	}
}
