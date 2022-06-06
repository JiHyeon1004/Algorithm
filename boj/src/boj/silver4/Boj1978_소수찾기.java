package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1978_소수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 숫자의 개수 N
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; // 숫자의 개수만큼 배열을 만들어준다.
		int cnt = 0; // 소수의 수

		st = new StringTokenizer(br.readLine());
		// 숫자 개수만큼 돌린다.
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken()); // 숫자 입력
			// 일단 소수라고 치자
			boolean isPrime = true;
			// 1은 소수가 아니야
			if (num[i] == 1) {
				isPrime = false;
			}
			// 2부터 올라가면서 나눈다.
			// 깔끔히 나누어떨어지면 소수가 아니므로
			// false로 바꾸고 break
			// 2는 소수이므로 제외하고 돌린다.
			if (num[i] > 2) {
				for (int j = 2; j <= num[i] / 2; j++) {
					if (num[i] % j == 0) {
						isPrime = false;
						break;
					}
				}
			}
			// 소수라면 카운트 올려준다.
			if (isPrime == true) {
				cnt++;
			}
		}
		// 카운트 출력
		System.out.println(cnt);
	}
}
