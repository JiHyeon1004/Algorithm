package boj.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;

		StringBuilder sb = new StringBuilder();

		HashSet<String> known = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			known.add(name);
		}
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (known.contains(name)) {
				sb.append(name).append('\n');
				cnt++;
			}
		}

		sb.insert(0, cnt).insert(1, '\n');

		System.out.println(sb.toString());
	}
}
