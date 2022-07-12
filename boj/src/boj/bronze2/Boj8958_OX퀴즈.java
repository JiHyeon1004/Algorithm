package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스의 수
		int T = Integer.parseInt(br.readLine());

		// 테스트케이스만큼 돌린다.
		for (int i = 0; i < T; i++) {
			String str = br.readLine(); // 한 줄 입력받고
			char[] quiz = str.toCharArray(); // 차 배열로
			// 같은 크기로 점수 배열 생성
			int[] score = new int[quiz.length];

			// 배열 돌면서
			for (int j = 0; j < quiz.length; j++) {
				// 틀렸으면 0점
				if (quiz[j] == 'X') {
					score[j] = 0;
				}
				// 맞았는데 첫 문제이거나 앞 문제를 틀렸으면 1점
				else if ((j == 0 || quiz[j - 1] == 'X') && quiz[j] == 'O') {
					score[j] = 1;
				}
				// 연속해서 맞았으면 앞 문제 점수에 +1점
				else if (quiz[j] == 'O' && quiz[j - 1] == 'O') {
					score[j] = score[j - 1] + 1;
				}
			}

			int sum = 0; // 점수합
			// 점수배열 돌면서 점수합을 구해준다.
			for (int j = 0; j < score.length; j++) {
				sum += score[j];
			}
			// 출력
			System.out.println(sum);
		}
	}
}
