package bronze3;

import java.util.Scanner;

public class Boj4153_직각삼각형 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); // 출력을 위한 스트링빌더

		// 와일문 돌려
		while (true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();

			// 0들어오면 깬다.
			if (A == 0) {
				break;
			}

			// 피타고라스의 정리가 성립하는지 확인
			if (A * A + B * B == C * C || A * A + C * C == B * B || C * C + B * B == A * A) {
				sb.append("right" + "\n");
			} else {
				sb.append("wrong" + "\n");
			}
		}

		// 출력
		System.out.println(sb);
	}
}
