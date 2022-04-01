package boj.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966_프린터큐 {
	public static void main(String[] args) throws IOException {
		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 스트링빌더 사용
		StringBuilder sb = new StringBuilder();

		// 테스트케이스 수
		int T = Integer.parseInt(st.nextToken());

		// 테스트케이스만큼 돌린다.
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 문서의 개수
			int idx = Integer.parseInt(st.nextToken()); // 우리가 원하는 문서의 인덱스
			// 큐 생성해준다.
			Queue<Integer> importantdocument = new LinkedList<>();
			PriorityQueue<Integer> priorityqueqe = new PriorityQueue<>(Collections.reverseOrder());

			// 문서 순서대로 중요도를 받아준다.
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				int priority = Integer.parseInt(st.nextToken()); // 중요도
				importantdocument.offer(priority); // 큐에도 add
				priorityqueqe.offer(priority); // 우선순위큐에도 add
			}

			int cnt = 0; // 프린트 순서

			// 큐의 맨 앞 친구가 우선순위가 가장 높다면 빼주고, 아니라면 뒤로 보낸다.
			// idx는 우리가 요하는 문서의 위치
			while (true) {
				// 우리가 요하는 문서가 맨 앞에 있지 않고 맨 앞 원소의 우선순위가 가장 높다면
				if (idx != 0 && importantdocument.peek() == priorityqueqe.peek()) {
					importantdocument.poll(); // 맨 앞 원소를 빼주고
					priorityqueqe.poll(); // 제일 큰 우선순위도 빼준다.
					cnt++; // 프린트순서 1 증가
					idx--; // 우리가 요하는 문서의 순서는 1 감소한다.
				}
				// 우리가 요하는 문서가 맨 앞에 있지 않고 맨 앞 원소의 우선순위가 가장 높지 않다면
				else if (idx != 0 && importantdocument.peek() != priorityqueqe.peek()) {
					importantdocument.offer(importantdocument.peek()); // 맨 앞 원소를 맨 뒤에 추가해주고
					importantdocument.poll(); // 맨 앞 원소 삭제
					idx--; // 우리가 요하는 문서의 순서는 1 감소한다.
				}
				// 우리가 요하는 문서가 맨 앞에 있고 우선순위가 가장 높다면
				else if (idx == 0 && importantdocument.peek() == priorityqueqe.peek()) {
					cnt++; // 프린트 순서 1 증가시켜주고
					break; // while문을 끝낸다.
				}
				// 우리가 요하는 문서가 맨 앞에 있고 우선순위가 가장 높지 않다면
				else if (idx == 0 && importantdocument.peek() != priorityqueqe.peek()) {
					importantdocument.offer(importantdocument.peek()); // 맨 앞 원소를 맨 뒤에 추가해주고
					importantdocument.poll(); // 맨 앞 원소 삭제
					idx = importantdocument.size() - 1; // idx를 맨 뒤로 보낸다.
				}
			}

			// 스트링빌더에 cnt 추가해준다ㅣ.
			sb.append(cnt).append('\n');
		}
		// 출력
		System.out.println(sb);
	}
}
