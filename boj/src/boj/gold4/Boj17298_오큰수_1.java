package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298_오큰수_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//시간초과

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 수열 수
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> num = new Stack<>(); // 수열
		Stack<Integer> temp = new Stack<>(); // 잠시 옮겨놓을 스택
		int[] arr = new int[N]; // 기준점

		// 수열 입력받는다.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num.push(Integer.parseInt(st.nextToken()));
			arr[i] = num.peek();
		}

		// 각각의 답을 순차적으로 구한다.
		for (int i = 1; i <= N; i++) {
			int ans = -1; // ans의 초기값은 -1
			int A = arr[i - 1]; // 기준점

			// 기준점이 peek이 될 때까지 수를 temp에 옮겨담는다.
			while (num.size() > i) {
				temp.add(num.pop());
				// 만약 temp.peek()이 기준보다 크다면 ans에 담는다.
				if (temp.peek() > A) {
					ans = temp.peek();
				}
			}
			// 스트링빌더에 붙여준다.
			sb.append(ans + " ");

			// 원상복구
			while (temp.size() > 0) {
				num.add(temp.pop());
			}
		}

		// 출력
		System.out.println(sb);
	}
}