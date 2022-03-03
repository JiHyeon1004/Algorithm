package boj.bronze2;

import java.util.Scanner;

public class Boj13300_방배정 {
	public static void main(String[] args) {

		// 스캐너로 입력받는다
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 한 방의 정원
		int[][] student = new int[2][7]; // 행은 성별, 열은 학년
		int room = 0; // 필요한 방의 수

		// 학생정보를 입력받아 배열에 저장한다.
		for (int i = 0; i < N; i++) {
			student[sc.nextInt()][sc.nextInt()]++;
		}
		// 스캐너 닫아주기
		sc.close();

		// 성별, 학년에 따라 돌면서
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				// K로 나누어떨어진다면
				if (student[i][j] % K == 0) {
					room += student[i][j] / K; // 학생수/K만큼 추가
				} else { // 나누어떨어지지 않는다면
					room += student[i][j] / K + 1; // +1까지 해주자
				}
			}
		}
		// 출력
		System.out.println(room);
	}

}
