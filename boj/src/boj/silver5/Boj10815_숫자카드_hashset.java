package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj10815_숫자카드_hashset {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> card = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (card.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1 + " ");
			} else {
				sb.append(0 + " ");
			}
		}
		System.out.println(sb);
	}
}
