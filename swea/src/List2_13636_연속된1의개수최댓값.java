package swea;

import java.util.Scanner;

public class List2_13636_연속된1의개수최댓값 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트케이스 T만큼 돌린다.
		for (int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			int[] intseq = new int[N];
			int max = 0;

			// 숫자를 문자열로 입력받아 하나씩 떼어내어 seq에 저장
			String[] seq = sc.next().split("");

			// seq에 저장된 문자열을 정수형으로 변환하여 intseq에 저장
			for (int i = 0; i < N; i++) {
				intseq[i] = Integer.parseInt(seq[i]);
			}

			// 앞 숫자와 본인이 0이 아니라면 본인은 앞 숫자에 1을 더하여 저장
			// 반복하면 01110의 경우 01230이 될 것
			for (int i = 1; i < N; i++) {
				if (intseq[i - 1] != 0 && intseq[i] != 0) {
					intseq[i] = (intseq[i - 1] + 1);
				}
			}

			// intseq에서 가장 큰 수를 max로
			for (int i = 0; i < N; i++) {
				if (intseq[i] > max) {
					max = intseq[i];
				}

			}

			// max출력
			System.out.printf("#%d %d \n", x, max);
		}
	}

}
