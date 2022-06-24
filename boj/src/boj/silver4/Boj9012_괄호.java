package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());

		// 테스트케이스만큼 돌린다.
		for (int i = 0; i < T; i++) {
			// 한 줄 입력받고
			String str = br.readLine();
			// VPS인지 판별하는 인자
			boolean isVPS = true;
			// 스택 생성해준다.
			Stack<Character> stack = new Stack<>();

			// 스트링의 길이만큼 돌면서
			for (int j = 0; j < str.length(); j++) {
				char a = str.charAt(j); // 한 글자씩 떼어
				// 여는 괄호이면 stack에 push
				if (a == '(') {
					stack.push(a);
				}
				// 닫는 괄호이지만 스택이 비었으면 짝이 안맞으므로 false
				else if (a == ')' && stack.isEmpty()) {
					isVPS = false;
				}
				// 이 외에는 pop해준다.ㅣ
				else {
					stack.pop();
				}
			}

			// VPS가 true이고 스택이 비었다면 yes
			// 스택이 비어있지 않다는 것은 여는 괄호가 더 많다는 것임
			if (isVPS && stack.isEmpty()) {
				System.out.println("YES");
			}
			// NO출력
			else {
				System.out.println("NO");
			}
		}
	}
}
