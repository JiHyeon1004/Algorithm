package silver5;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1417_국회의원선거 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// 우선순위 큐 사용
		PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder());

		int N = sc.nextInt(); // 후보자의 수
		int ds = sc.nextInt(); // 다솜이의 지지자
		int cnt = 0; // 매수필요자의 수

		// 후보자가 두 명 이상일 경우
		if (N > 1) {

			// 다른 후보자의 지지자 수 받아주고
			for (int i = 1; i < N; i++) {
				candidate.add(sc.nextInt());
			}

			// 다솜이가 이길때까지 돌린다.
			while (candidate.peek() >= ds) {
				ds++; // 다솜 지지자 추가
				// 가장 많은 지지자를 가진 후보자의 지지자를 매수한다.
				candidate.add(candidate.peek() - 1);
				candidate.poll();
				// 매수인원 추가
				cnt++;
			}
		}
		// 매수인원 출력
		System.out.println(cnt);
	}
}
