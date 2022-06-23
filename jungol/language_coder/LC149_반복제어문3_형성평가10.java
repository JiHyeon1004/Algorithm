package language_coder;

import java.util.Scanner;

public class LC149_반복제어문3_형성평가10 {
	public static void main(String[] args) {
		// 10이하의 홀수 배열 준비
		int[] num = { 1, 3, 5, 7, 9 };
		// 출력을 위한 스트링빌더
		StringBuilder sb = new StringBuilder();
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// N입력받음
		int N = sc.nextInt();
		int cnt = 0; // 홀수 배열을 돌기 위한 카운트

		// N*N으로 가면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(num[cnt % 5] + " "); // cnt를 5로 나눈 나머지가 인덱스에 해당하는 배열값을 가져온다.
				cnt++; // 카운트 늘려주고
			}
			// 엔터 입력
			sb.append('\n');
		}
		// 출력
		System.out.println(sb);
	}
}
