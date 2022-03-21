package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj10814_나이순정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		String[][] member = new String[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			member[i][0] = st.nextToken();
			member[i][1] = st.nextToken();
		}

		Arrays.sort(member, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}

		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(member[i][0]).append(" ").append(member[i][1]).append("\n");
		}
		System.out.println(sb.toString());

	}

}
