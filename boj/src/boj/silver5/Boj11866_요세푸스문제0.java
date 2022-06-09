package silver5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj11866_요세푸스문제0 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 사람들을 넣을 큐
		Queue<Integer> people = new LinkedList<>();

		// 사람 수
		int N = sc.nextInt();
		int K = sc.nextInt(); // 규칙

		// 사람을 큐에 넣는다.
		for (int i = 1; i <= N; i++) {
			people.add(i);
		}

		// 출력을 위한 괄호
		sb.append("<");

		// 큐가 비어있지 않다면 돌려
		while (!people.isEmpty()) {
			// K-1만큼 돌리고
			for (int i = 0; i < K - 1; i++) {
				people.add(people.poll());
			}
			// 하나 빼서 출력값에 넣어줘
			sb.append(people.poll());

			// 마지막이 아니라면 쉼표 붙여줘
			if (!people.isEmpty()) {
				sb.append(", ");
			}
		}
		// 마지막에 괄호 닫아주고
		sb.append(">");

		// 출력
		System.out.println(sb);
	}
}
