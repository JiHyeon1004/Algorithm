package language_coder;

import java.util.Scanner;

public class LC174_함수1_형성평가5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 사람수. 과목1, 과목2, 과목3, 합 배열
		int[][] score = new int[3][4];

		// 과목입력받고 마지막 칸은 합으로 채워준다.
		for (int i = 0; i < 3; i++) {
			score[i][0] = sc.nextInt();
			score[i][1] = sc.nextInt();
			score[i][2] = sc.nextInt();
			score[i][3] = score[i][0] + score[i][1] + score[i][2];
		}

		// 출력해주고
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d %d %d %d", score[i][0], score[i][1], score[i][2], score[i][3]);
			System.out.println();
		}
		// 마지막은 세로 합
		for (int i = 0; i < 4; i++) {
			int sum = score[0][i] + score[1][i] + score[2][i];
			sb.append(sum + " ");
		}
		// 세로합 출력
		System.out.println(sb);
	}
}
