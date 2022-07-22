package silver5;

import java.util.Scanner;

public class Boj2581_소수 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		// 범위 입력
		int M = sc.nextInt();
		int N = sc.nextInt();
		// 소수인지 아닌지 저장할 배열
		int[] primeNo = new int[N + 1];

		// M부터N까지 소수인지 확인
		for (int i = M; i <= N; i++) {
			// 소수인지 확인할 boolean
			boolean isPrime = true;
			// 1은 소수가 아님
			if (i == 1) {
				continue;
			}
			// 2는 소수
			else if (i == 2) {
				primeNo[i] = 1;
			}
			// 이외
			else {
				for (int j = 2; j <= i / 2; j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}
				// 소수면 primeNo에 1로 저장
				if (isPrime) {
					primeNo[i] = 1;
				}
			}
		}

		int sum = 0; // 합
		int firstPrime = 0; // 최소 소수
		// 가장 작은 소수 찾는다.
		for (int i = M; i < N + 1; i++) {
			if (primeNo[i] == 1) {
				firstPrime = i;
				break;
			}
		}
		// 합 구한다.
		for (int i = M; i < N + 1; i++) {
			if (primeNo[i] == 1) {
				sum += i;
			}
		}
		// 소수가 없다면
		if (sum == 0) {
			System.out.println(-1);
		}
		// 출력
		else {
			System.out.println(sum);
			System.out.println(firstPrime);
		}
	}
}
