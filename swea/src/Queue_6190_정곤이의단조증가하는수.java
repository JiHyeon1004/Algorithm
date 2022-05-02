package swea;

import java.util.Scanner;

public class Queue_6190_정곤이의단조증가하는수 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 수

		// 테스트케이스만큼 돌려준다.
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 숫자의 개수
			int[] num = new int[N]; // 숫자 배열 만들어준다.
			int max = 0; // 최댓값은 일단 0

			// 숫자 입력받아 배열 채워줌
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}

			// 서로 다른 두 수를 뽑아서 그 곱이 단조증가이고 max보다 크다면 max에 곱한 값을 저장
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					int multiple = 0;
					if (i < j) {
						multiple = num[i] * num[j];
						if (monoinc(multiple) && multiple > max) {
							max = multiple;
						}
					}
				}
			}
			System.out.print("#" + tc);
			// max가 0이면 단조증가하는 수가 없으므로 -1 출력
			if (max == 0) {
				System.out.println(" " + "-1");
			}
			// max가 0이 아니라면 max 출력
			else {
				System.out.println(" " + max);
			}
		}
		sc.close();
	}

	public static boolean monoinc(int mltpl) {
		while (mltpl > 9) {
			String numstr = String.valueOf(mltpl);
			if (numstr.charAt(numstr.length() - 2) - '0' > numstr.charAt(numstr.length() - 1) - '0') {
				return false;
			}
			mltpl = mltpl / 10;
		}
		return true;
	}
}
