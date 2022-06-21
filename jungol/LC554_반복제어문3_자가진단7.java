package language_coder;

import java.util.Scanner;

public class LC554_반복제어문3_자가진단7 {
	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);
		// 출력을 위한 스트링빌더
		StringBuilder sb = new StringBuilder();

		// N입력받는다.
		int N = sc.nextInt();
		int num = 1; // 시작 수는 1
		char alphabet = 'A'; // 시작 알파벳은 A

		// N*N+1크기를 도렴ㄴ서
		for (int i = 0; i < N; i++) {
			// N-i(행) 만큼은 숫자를
			for (int j = N - i; j > 0; j--) {
				sb.append(num + " ");
				num++; // 숫자 증가
			}
			// 나머지는 문자를
			for (int k = 1; k <= i + 1; k++) {
				sb.append(alphabet + " ");
				alphabet++; // 문자 증가
			}
			// 엔터 입력
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}
