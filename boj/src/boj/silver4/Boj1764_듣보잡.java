package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 듣도 못한 사람의 수, 보도 못한 사람의 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0; // 듣보잡의 수

		// 중복을 체크하기 위해 헤쉬셋 사용
		HashSet<String> known = new HashSet<>();

		// 듣보잡을 넣을 리스트
		List<String> dbj = new ArrayList<>();

		// 듣도 못한 사람을 셋에 넣는다.
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			known.add(name);
		}
		// 보도 못한 사람이 듣도 못한 사람인지 체크
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (known.contains(name)) {
				dbj.add(name);
				cnt++;
			}
		}
		// 사전순으로 정렬
		Collections.sort(dbj);

		// 출력
		System.out.println(cnt);
		for (int i = 0; i < dbj.size(); i++) {
			System.out.println(dbj.get(i));
		}
	}
}