package silver4;

import java.util.Scanner;

public class Boj1065_한수 {
	static int N; // 입력받을 수
	static int cnt; // 한수의 개수

	public static void main(String[] args) {
		// 스캐너로 입력받는다.
		Scanner sc = new Scanner(System.in);

		// 숫자 입력받고 한수의 개수 0으로 초기화
		N = sc.nextInt();
		cnt = 0;

		// 100보다 작다면 다 한수임
		if (N < 100) {
			cnt = N;
		}

		// 100보다 크다면
		else {
			cnt = 99; // 100이전은 모두 한수
			isSequence(N); // 100부터 isSequence돌린다.
		}

		// 답 출력
		System.out.println(cnt);
	}

	// isSequence
	private static void isSequence(int n) {

		// 100부터 N까지
		for (int i = 100; i <= N; i++) {
			String num = String.valueOf(i); // 문자열로 바꾸고
			char[] arr = num.toCharArray(); // 문자 배열로 만든다.

			// 0번째와 1번째 숫자의 차를 gap으로 두고
			int gap = arr[0] - arr[1];
			boolean flag = true; // 한수인지 아닌지 판단할 boolean

			// 숫자의 자릿수만큼 돌면서
			for (int j = 1; j < arr.length - 1; j++) {
				// 갭이 다르면 flag를 false로 바꾸고 깬다.
				if (arr[j] - arr[j + 1] != gap) {
					flag = false;
					break;
				}
			}
			// flag가 true라면 한수의 개수 1 추가
			if (flag) {
				cnt++;
			}
		}
	}
}