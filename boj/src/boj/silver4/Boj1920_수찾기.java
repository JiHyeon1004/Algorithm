package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj1920_수찾기 {
	public static void main(String[] args) throws IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더
		StringTokenizer st;

		// N입력
		int N = Integer.parseInt(br.readLine());

		// 해쉬셋 만들어줌
		HashSet<Integer> num = new HashSet<>();

		// 헤쉬셋에 넣어준다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num.add(Integer.parseInt(st.nextToken()));
		}

		// M입력
		int M = Integer.parseInt(br.readLine());

		// 헤쉬셋과 비교해서 존재하면 1, 존재하지 않으면 0
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (num.contains(Integer.parseInt(st.nextToken()))) {
				sb.append("1" + "\n");
			} else {
				sb.append("0" + "\n");
			}
		}
		// 출력
		System.out.println(sb);
	}
}
