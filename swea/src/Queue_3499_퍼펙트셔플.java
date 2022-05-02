package swea;

import java.util.Scanner;

public class Queue_3499_퍼펙트셔플 {
	public static void main(String[] args) {

		//스캐너로 입력 받아줌
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		//테스트케이스만큼 돌려준다
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d", tc);
			int N = sc.nextInt(); //카드 개수
			String[] card = new String[N + 1]; //1번부터 시작할거라서 하나 큰 배열 만들었다.
			String[] shuffled = new String[N + 1]; //섞인 후에 카드배열

			//1번부터 카드 배열 입력받기
			for (int i = 1; i <= N; i++) {
				card[i] = sc.next();
			}

			//짝수개라면
			if (N % 2 == 0) {
				//교대로~
				for (int i = 1; i <= N / 2; i++) {
					shuffled[(2 * i - 1)] = card[i];
					shuffled[2 * i] = card[N / 2 + i];
				}
			}

			//홀수개라면
			if (N % 2 != 0) {
				//교대로 하는데 홀수번째 카드뭉치가 하나 더 많아
				for (int i = 1; i <= N / 2; i++) {
					shuffled[(2 * i - 1)] = card[i];
					shuffled[2 * i] = card[N / 2 + i + 1];
				}
				//마지막 카드는~
				shuffled[N] = card[N / 2 + 1];
			}

			//출력
			for (int i = 1; i <= N; i++) {
				System.out.print(" " + shuffled[i]);
			}
			System.out.println();
		}
	}

}
