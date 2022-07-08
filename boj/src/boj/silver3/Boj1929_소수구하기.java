package silver3;

import java.util.Scanner;

public class Boj1929_소수구하기 {
	// 에라토스테네스의 체

	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		// 출력을 위한 스트링빌더
		StringBuilder sb = new StringBuilder();

		// 시작값 M과 끝값 N
		int M = sc.nextInt();
		int N = sc.nextInt();

		// 소수인지 판별할 배열
		boolean[] isPrime = new boolean[N + 1];
		// 범위 외는 모두 false
		for (int i = M; i <= N; i++) {
			isPrime[i] = true;
		}
		// 0과 1은 소수가 아니다.
		isPrime[0] = false;
		isPrime[1] = false;

		// 에라토스테네스의 체
		for (int i = 2; i * i <= N; i++) {
			for (int j = i * i; j <= N; j += i) {
				isPrime[j] = false;
			}
		}

		// 소수이면 sb에 붙인다.
		for (int i = M; i <= N; i++) {
			if (isPrime[i]) {
				sb.append(i).append("\n");
			}
		}

		// 출력
		System.out.println(sb);
	}

}
