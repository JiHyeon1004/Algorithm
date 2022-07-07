package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj10866_덱 {
	public static void main(String[] args) throws IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 명령의 개수
		int N = Integer.parseInt(br.readLine());
		// 덱 생성
		Deque<Integer> num = new LinkedList<>();

		// 명령의 개수만큼 돌린다.
		for (int i = 0; i < N; i++) {
			// 명령 입력받아서 띄어쓰기 기준으로 찢음.
			String command = br.readLine();
			String[] cmd = command.split(" ");

			// 명령어에 따라 수행
			switch (cmd[0]) {
			case "push_back":
				num.addLast(Integer.parseInt(cmd[1]));
				break;

			case "push_front":
				num.addFirst(Integer.parseInt(cmd[1]));
				break;

			case "pop_front":
				if (!num.isEmpty()) {
					System.out.println(num.removeFirst());
				} else {
					System.out.println("-1");
				}
				break;

			case "pop_back":
				if (!num.isEmpty()) {
					System.out.println(num.removeLast());
				} else {
					System.out.println("-1");
				}
				break;

			case "size":
				System.out.println(num.size());
				break;

			case "empty":
				// 비어있으면 1 출력, 아니면 0 출력
				System.out.println(num.isEmpty() ? "1" : "0");
				break;

			case "front":
				if (!num.isEmpty()) {
					System.out.println(num.peekFirst());
				} else {
					System.out.println("-1");
				}
				break;

			case "back":
				if (!num.isEmpty()) {
					System.out.println(num.peekLast());
				} else {
					System.out.println("-1");
				}
				break;

			}
		}
	}
}
