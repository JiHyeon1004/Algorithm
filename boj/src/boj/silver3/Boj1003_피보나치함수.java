package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1003_피보나치함수 {

	static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws NumberFormatException, IOException {

		dp[0][0] = 1; // N=0 일 때 0 호출횟수
		dp[0][1] = 0; // N=0 일 때 1 호출횟수
		dp[1][0] = 0; // N=1 일 때 0 호출횟수
		dp[1][1] = 1; // N=1 일 때 1 호출횟수

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		// 테스트케이스만큼 돌린다.
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // N입력받고
			// fibonacci돌림
			fibonacci(N);
			// 결과 스트링빌더에 붙이기
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}
		// 출력
		System.out.println(sb);
	}

	// fibonacci
	private static Integer[] fibonacci(int n) {
		// 아직 모르는 값이라면
		if (dp[n][0] == null || dp[n][1] == null) {
			// 구해라
			dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
		}

		return dp[n];

	}
}
