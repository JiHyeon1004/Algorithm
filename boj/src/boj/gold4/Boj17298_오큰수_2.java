package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298_오큰수_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더
		Stack<Integer> ans = new Stack<>(); // 정답스택
		Stack<Integer> tmp = new Stack<>(); // 임시스택

		// 수열을 구성하는 숫자의 개수
		int N = Integer.parseInt(br.readLine());
		// 수열입력
		String[] input = br.readLine().split(" ");

		// 기준점을 오른쪽 끝부터 하나씩 줄여가며 실행
		for (int i = N - 1; i >= 0; i--) {
			int num = Integer.parseInt(input[i]); // 기준점
			// tmp가 비어있지 않고 num이 tmp.peek보다 크다면 tmp.pop
			while (!tmp.isEmpty() && num >= tmp.peek()) {
				tmp.pop();
			}
			// 만약 tmp가 비었다면 num이 제일 크다는 뜻이므로 -1을 ans에 추가
			if (tmp.isEmpty()) {
				ans.add(-1);
			}
			// 그게 아니라면 tmp의 peek을 ans에 추가
			else {
				ans.add(tmp.peek());
			}
			// tmp에 num(현재 기준점) 추가
			tmp.add(num);
		} // for

		// 정답스택을 스트링빌더에 담는다.
		while (!ans.isEmpty()) {
			sb.append(ans.pop() + " ");
		}

		// 출력
		System.out.println(sb);

	}
}