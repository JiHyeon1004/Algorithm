package swea;

import java.util.Scanner;

public class Stack_5215_햄버거다이어트 {
	// 전역변수 선언
	static boolean[] sel;
	static int[] score;
	static int[] cal;
	static int N; // 재료 수
	static int L; // 칼로리 제한
	static int ssum; // 점수 합
	static int csum; // 칼로리 합
	static int max; // 칼로리 제한 내에서 최대 점수

	// 메인
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 입력받음

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= T; tc++) {
			max = 0; // max 초기화
			N = sc.nextInt(); // N입력받고
			score = new int[N]; // N크기의 점수와 칼로리배열 생성
			cal = new int[N];
			L = sc.nextInt(); // L입력받음

			// 점수와 칼로리 입력받아서 배열 채운다.
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			// sel은 N길이의 불리안
			sel = new boolean[N];

			// 첫 번째 재료부터 진행하겠다.
			hamburger(0);
			// max를 출력
			System.out.printf("#%d %d\n", tc, max);
		}

		sc.close();
	}

	// 햄버거~~
	public static void hamburger(int idx) {
		// sel길이만큼 진행했다면
		if (idx == sel.length) {
			ssum = 0; // 초기화
			csum = 0; // 초기화
			// 탐색하면서 선택되었으면 새로운 배열에 담아!
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					ssum += score[i]; // 점수합
					csum += cal[i]; // 칼로리합
				}
				// 만약 칼로리합이 칼로리제한 이하이면
				if (csum <= L) {
					// max값 처리
					if (ssum > max) {
						max = ssum;
					}
				}
				// 날 불러준 곳으로~
				return;
			}
			// 뽑부터 시작
			sel[idx] = true; // 뽑
			hamburger(idx + 1); // 인덱스 하나 올려서 고
			sel[idx] = false; // 안뽑
			hamburger(idx + 1); // 인덱스 하나 올려서 고
		}
	}
}
