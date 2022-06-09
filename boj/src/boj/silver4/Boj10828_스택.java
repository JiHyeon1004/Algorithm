package silver4;

import java.util.Scanner;
import java.util.Stack;

public class Boj10828_스택 {
	public static void main(String[] args) {
		// if보다 case가 깔끔했을듯

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 스택 만들어줌
		Stack<Integer> num = new Stack<>();

		int N = sc.nextInt(); // 명령의 개수
		// 명령의 개수만큼 돌린다.
		for (int i = 0; i < N; i++) {
			String command = sc.nextLine(); // 명령
			String[] spt = command.split(" "); // 명령을 찢자

			// pop이라면
			if (spt[0].equals("pop")) {
				// 스택이 비었다면
				if (num.isEmpty()) {
					sb.append(-1).append("\n");
				}
				// 스택이 비어있지 않다면
				else {
					sb.append(num.pop()).append("\n");
				}
			}
			// size라면
			else if (spt[0].equals("size")) {
				sb.append(num.size()).append("\n"); // 사이즈 출력
			}
			// empty라면
			else if (spt[0].equals("empty")) {
				// 스택이 비어있다면
				if (num.isEmpty()) {
					sb.append(1).append("\n");
				}
				// 스택이 비어있지 않다면
				else {
					sb.append(0).append("\n");
				}
			}
			// top이라면
			else if (spt[0].equals("top")) {
				// 스택이 비어있다면
				if (num.isEmpty()) {
					sb.append(-1).append("\n");
				}
				// 스택이 비어있지 않다면
				else {
					sb.append(num.peek()).append("\n");
				}
			}
			// push라면
			else if (spt[0].equals("push")) {
				num.push(Integer.parseInt(spt[1]));
			}
		}
		// 출력
		System.out.println(sb);
	}
}
