package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10989_수정렬하기3_countingsort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 숫자의 개수
		int N = Integer.parseInt(br.readLine());

		// 배열 만들어버리고
		int[] cnt = new int[10001];

		// 배열에 개수 입력받는다.
		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}

		// 순서대로, 개수대로 출력
		for (int i = 1; i < 10001; i++) {
			while (cnt[i] > 0) {
				sb.append(i).append("\n");
				cnt[i]--;
			}
		}
		// 출력
		System.out.println(sb);
	}
}
