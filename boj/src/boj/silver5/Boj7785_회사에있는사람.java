package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj7785_회사에있는사람 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 로그의 수
		int n = Integer.parseInt(br.readLine());

		// 헤쉬셋 만들어준다.
		HashSet<String> log = new HashSet<>();

		// 로그를 돌면서
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			// 이름이 이미 있다면
			if (log.contains(name)) {
				log.remove(name); // 셋에서 삭제
			}
			// 없다면
			else {
				log.add(name); // 추가
			}
		}
		// 로그를 배열로 바꿔서 정렬
		String[] now = new String[log.size()];
		log.toArray(now);
		Arrays.sort(now);

		// 뒤부터 출력
		for (int i = now.length - 1; i >= 0; i--) {
			System.out.println(now[i]);
		}
	}
}
