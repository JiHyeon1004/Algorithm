package silver4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj10845_큐 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 명령의 수
		StringBuilder sb = new StringBuilder(); // 출력 위한 스트링빌더

		// 큐 생성
		Queue<Integer> num = new LinkedList<Integer>();

		// 명령받고 처리
		for (int i = 0; i <= N; i++) {
			String command = sc.nextLine(); // 명령
			String[] spt = command.split(" "); // push를 대비하여 띄어쓰기를 기준으로 쪼갠다.

			// 명령을 기준으로
			switch (spt[0]) {
			// push라면
			case "push":
				num.add(Integer.parseInt(spt[1]));

				break;

			// pop이라면
			case "pop":
				if (!num.isEmpty()) {
					sb.append(num.poll()).append("\n");
				} else {
					sb.append("-1").append('\n');
				}
				break;

			// size라면
			case "size":
				sb.append(num.size()).append('\n');

				break;

			// empty라면
			case "empty":
				if (num.isEmpty()) {
					sb.append("1").append('\n');
				} else {
					sb.append("0").append('\n');
				}

				break;

			// front라면
			case "front":
				if (!num.isEmpty()) {
					sb.append(num.peek()).append('\n');
				} else {
					sb.append("-1").append('\n');
				}

				break;

			// back이라면
			case "back":
				if (num.size() > 1) {
					for (int j = 1; j < num.size(); j++) {
						num.add(num.poll());
					}
					sb.append(num.peek()).append('\n');
					num.add(num.poll());
				} else if (num.size() == 1) {
					sb.append(num.peek()).append('\n');
				} else {
					sb.append("-1").append('\n');
				}

				break;
			}

		}
		// 출력
		System.out.println(sb);
	}
}
