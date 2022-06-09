package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10818_최소최대 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 숫자의 개수
		int N = Integer.parseInt(br.readLine());
		int max = -1000001; // 최댓값
		int min = 1000001; // 최솟값

		// 숫자를 담을 배열
		int[] arr = new int[N];

		// 1부터 n까지 돌면서
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// 숫자를 배열에 담고
			arr[i] = Integer.parseInt(st.nextToken());
			// max보다 크다면
			if (arr[i] > max) {
				max = arr[i]; // 갱신
			}
			// min보다 작다면
			if (arr[i] < min) {
				min = arr[i]; // 갱신
			}
		}

		// 출력
		System.out.println(min + " " + max);

	}
}
