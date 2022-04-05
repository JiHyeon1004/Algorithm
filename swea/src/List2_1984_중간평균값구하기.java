package swea;

import java.util.Scanner;

public class List2_1984_중간평균값구하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] num = new int[10];
		int tmp = 0;
		int sum = 0;

		// 테스트케이스만큼 반복한다.
		for (int x = 1; x <= T; x++) {

			for (int i = 0; i < 10; i++) {
				num[i] = sc.nextInt();
			}

			// 버블소트로 오름차순 정렬
			for (int i = 9; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (num[j] > num[j + 1]) {
						tmp = num[j];
						num[j] = num[j + 1];
						num[j + 1] = tmp;
					}
				}
			}

			// 최소, 최대 수를 제외한 값들을 모두 더함
			for (int i = 1; i < 9; i++) {
				sum += num[i];
			}

			// 평균을 구하여 반올림한 정수로 출력
			double avg = sum * 0.125;
			System.out.print("#" + x);
			System.out.println(" " + Math.round(avg));
			
			//sum 초기화
			sum = 0;
		}
	}

}
