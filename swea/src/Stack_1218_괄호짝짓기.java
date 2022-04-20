package swea;

import java.util.Scanner;
import java.util.Stack;

public class Stack_1218_괄호짝짓기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 테스트케이스만큼 돌린다.
		for (int x = 1; x <= 10; x++) {
			// stack 생성
			Stack<Character> brckt = new Stack<>();
			// N과 문자열 입력받음
			int N = sc.nextInt();
			String input = sc.next();
			// char로 만들어준다
			char[] bracket = new char[N];
			bracket = input.toCharArray();
			// ans을 1로 초기화
			int ans = 1;

			// 전체 탐색
			for (int i = 0; i < N; i++) {
				// 괄호를 열어준다면 push한다.
				if (bracket[i] == '(' || bracket[i] == '[' || bracket[i] == '{' || bracket[i] == '<') {
					brckt.push(bracket[i]);
				}
				// 괄호를 닫아준다면, top에 그 괄호를 열어주는 짝이 있는지 확인하여 pop. 아니면 유효하지 않음.
				else if (bracket[i] == ')') {
					if (brckt.peek() == '(') {
						brckt.pop();
					} else {
						ans = 0;
						break;
					}
				} else if (bracket[i] == ']') {
					if (brckt.peek() == '[') {
						brckt.pop();
					} else {
						ans = 0;
						break;
					}
				} else if (bracket[i] == '}') {
					if (brckt.peek() == '{') {
						brckt.pop();
					} else {
						ans = 0;
						break;
					}
				} else if (bracket[i] == '>') {
					if (brckt.peek() == '<') {
						brckt.pop();
					} else {
						ans = 0;
						break;
					}
				}
			}
			// 끝마친 후 stack이 비어있지 않다면 짝이 맞지 않으므로 0
			if (!brckt.empty()) {
				ans = 0;
			}
			// stack이 비었다면 짝이 맞는 것이므로 출력

			System.out.printf("#%d %d\n", x, ans);

		}
	}

}
