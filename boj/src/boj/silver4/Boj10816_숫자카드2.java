package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10816_숫자카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 버퍼드리더로 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 카드의 개수
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[20000001]; // 음수도 있으므로 +10000000해준다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 카드를 가지고 있으면 배열을 플러스해준다.
		for (int i = 0; i < N; i++) {
			card[Integer.parseInt(st.nextToken()) + 10000000]++;
		}

		// 확인할 숫자의 개수
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		// 배열에서 해당하는 숫자의 개수 읽어온다.
		for (int i = 0; i < M; i++) {
			sb.append(card[Integer.parseInt(st.nextToken()) + 10000000] + " ");
		}
		// 출력
		System.out.println(sb);
	}
}
