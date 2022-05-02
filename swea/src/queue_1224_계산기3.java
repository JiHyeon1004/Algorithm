package swea;

import java.util.Scanner;
import java.util.Stack;

public class queue_1224_계산기3 {
	public static void main(String[] args) {

		// 스캐너로 입력받음
		Scanner sc = new Scanner(System.in);

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= 10; tc++) {
			int L = sc.nextInt(); // 식의 길이
			String original = sc.next(); // 주어진 식
			Stack<Character> operater = new Stack<>(); // 연산자를 쌓을 스택
			String changed = ""; // 여기다가 새로운 식을 채울 것임
			Stack<Integer> cal = new Stack<>(); // 계산할 때 사용할 스택
			int ans = 0; // 답

			// 식의 길이만큼 돌린다.
			for (int i = 0; i < L; i++) {
				if (original.charAt(i) >= 48 && 57 >= original.charAt(i)) { // 숫자이면
					changed += original.charAt(i); // 새로운 식에 그대로 넣는다.
				} else if (original.charAt(i) == '(') { // 괄호가 열린다면
					operater.push(original.charAt(i)); // 연산자스택에 쌓는다.
				} else if (original.charAt(i) == '*') { // 곱하기라면
					while (operater.peek() == '*') { // top도 곱하기인 조건에서는
						changed += operater.pop(); // 새로운 식에 pop해서 넣어준다.
					}
					operater.push(original.charAt(i)); // 연산자스택에 푸쉬
				} else if (original.charAt(i) == '+') { // 더하기라면
					while (operater.peek() == '+' || operater.peek() == '*') { // top이 +이거나 *이면
						changed += operater.pop(); // 새로운 식에 pop해서 넣어준다.
					}
					operater.push(original.charAt(i)); // 연산자스택에 푸쉬
				} else {
					while (operater.peek() != '(') { // top이 (가 되기 전까지
						changed += operater.pop(); // 새로운 식에 pop해서 넣어준다.
					}
					operater.pop(); // 이제 (가 top이니깐 pop해서 없애주자
				}
			}
			while (!operater.isEmpty()) { // 스택이 빌 때 까지
				changed += operater.pop(); // 새로운 식에 pop해서 넣어준다.
			}

			// 새로운 식의 길이만큼 돌려준다.
			for (int i = 0; i < changed.length(); i++) {
				if (changed.charAt(i) >= 48 && 57 >= changed.charAt(i)) { // 숫자라면
					cal.push(changed.charAt(i) - '0'); // cal에 집어넣고
				} else if (changed.charAt(i) == '*') { // 곱하기라면
					int right = cal.pop(); // 첫 번째 꺼낸 수가 오른쪽
					int left = cal.pop(); // 두 번째 꺼낸 수가 왼쪽
					cal.push(left * right); // 왼*오를 계산기에 다시 집어넣어
				} else if (changed.charAt(i) == '+') { // 더하기라면
					int right = cal.pop(); // 첫 번째 꺼낸 수 오른쪽
					int left = cal.pop(); // 두 번째 꺼낸 수 왼쪽
					cal.push(left + right); // 왼+오를 계산기로 다시
				}
			}
			ans = cal.pop(); // 마지막 남은 수가 답이야

			// 출력
			System.out.printf("#%d %d\n", tc, ans);
		}
		// 스캐너 닫아줌
		sc.close();
	}

}
