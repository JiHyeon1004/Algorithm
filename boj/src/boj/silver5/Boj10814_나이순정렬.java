package boj.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj10814_나이순정렬 {

	public static void main(String[] args) throws IOException {
		// 버퍼트리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N 입력받고
		int N = Integer.parseInt(st.nextToken());
		// N*2의 배열 생성
		String[][] member = new String[N][2];

		// member배열 입력받음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			member[i][0] = st.nextToken(); // 나이
			member[i][1] = st.nextToken(); // 이름
		}

		// comparator로 정렬
		// 앞에가 더 나이 많으면 교체
		Arrays.sort(member, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}

		});

		// 스트링빌더로 만들어준다.
		StringBuilder sb = new StringBuilder();

		// 배열 돌면서 나이, 이름 담아준다.
		for (int i = 0; i < N; i++) {
			sb.append(member[i][0]).append(" ").append(member[i][1]).append("\n");
		}

		// 스트링빌더 출력
		System.out.println(sb.toString());

	}

}
