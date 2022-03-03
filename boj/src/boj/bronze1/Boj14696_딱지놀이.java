package boj.bronze1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Boj14696_딱지놀이 {
	public static void main(String[] args) {

		// 스캐너로 입력받아준다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 라운드 수

		// 라운드 수만큼 돌린다
		for (int i = 0; i < N; i++) {
			String ans = "D"; // 답의 기본값은 무승부
			int a = sc.nextInt(); // a학생의 그림 수
			Integer[] aArr = new Integer[a]; // a학생의 그림 배열
			for (int j = 0; j < a; j++) {
				aArr[j] = sc.nextInt();
			}
			int b = sc.nextInt(); // b학생의 그림 수
			Integer[] bArr = new Integer[b]; // b학생의 그림 배열
			for (int j = 0; j < b; j++) {
				bArr[j] = sc.nextInt();
			}

			// 그림 배열을 내림차순으로 정렬해줌
			Arrays.sort(aArr, Collections.reverseOrder());
			Arrays.sort(bArr, Collections.reverseOrder());

			for (int j = 0; j < Math.min(a, b); j++) {
				if (aArr[j] > bArr[j]) { // a배열의 수가 b배열의 수보다 크다면
					ans = "A"; // a 승
					break; // 이번 판 끝
				} else if (bArr[j] > aArr[j]) { // b배열의 수가 a배열의 수보다 크다면
					ans = "B"; // b 승
					break; // 이번 판 끝
				} else if (a > b && aArr[j] == bArr[j]) { // 둘이 같고 a가 b보다 길다면
					ans = "A"; // A로 저장
				} else if (a < b && aArr[j] == bArr[j]) { // 둘이 같고 b가 a보다 길다면
					ans = "B"; // B로 저장
				}
			}
			// 출력~
			System.out.println(ans);
		}
		// 스캐너 닫기
		sc.close();
	}
}
